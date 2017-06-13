/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;

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
}