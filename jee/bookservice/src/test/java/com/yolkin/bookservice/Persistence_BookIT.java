/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-06-05 08:23)
 */
public class Persistence_BookIT {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Before
    public void init(){
        entityManagerFactory = Persistence.createEntityManagerFactory("BookService_PU_4Test");
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    @After
    public void tearDown() {
        if (entityManager != null) {
            entityManager.close();
        }
    }


    @Test
    public void testShouldFindBookById() {
        Book book = entityManager.find(Book.class, 1001L);
        assertEquals("Beginning Java EE 7", book.getTitle());

        //check attached/detached entity state
        assertTrue(entityManager.contains(book));
        entityManager.detach(book);
        assertFalse(entityManager.contains(book));

        Cache cache = entityManagerFactory.getCache();
        assertTrue(cache.contains(Book.class, book.getId()));
        cache.evict(Book.class, book.getId());
        assertFalse(cache.contains(Book.class, book.getId()));
    }

    @Test(expected = ConstraintViolationException.class)
    public void testRaiseConstraintViolationException() {
        //Book title is null and description is less than 10 symbols(it's not allowed)
        Book book = new Book(
                null,
                20.f,
                "test book",
                "1-84023-742-2"
        );
        entityManager.persist(book);
    }

    @Test
    public void testCriteriaAPI_findBooksWithPrice(){
        //see test scenario details in insert.sql
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
        Root<Book> from = criteriaQuery.from(Book.class);
        criteriaQuery.select(from).where(builder.greaterThan(from.get("price").as(Double.class), 40.0));

        List<Book> books = entityManager.createQuery(criteriaQuery).getResultList();
        assertEquals(books.size(), 2);
    }
}