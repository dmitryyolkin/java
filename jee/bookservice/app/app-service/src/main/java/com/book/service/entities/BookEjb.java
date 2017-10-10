package com.book.service.entities;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (10.10.17)
 */
@Stateless
@LocalBean
public class BookEjb implements BookEjbRemote {
    /**
     * EJB получает ссылку на менеджер сущностей с использованием аннотации @Inject,
     * поскольку объект класса EntityManager создается объектом класса DatabaseProducer
     */
    @Inject
    private EntityManager entityManager;

    @Override
    public List<Book> findBooks() {
        return entityManager.createNamedQuery(Book.FIND_ALL, Book.class).getResultList();
    }

    @Override
    public Book create(Book b) {
        entityManager.persist(b);
        return b;
    }

    @Override
    public Book update(Book b) {
        //return new entity from DB
        return entityManager.merge(b);
    }

    @Override
    public void delete(Book b) {
        //Перед удалением объекта типа Book из базы данных этот метод
        //должен повторно прикрепить объект к менеджеру сущностей (с помощью метода merge() ),
        //а затем удалить его
        entityManager.remove(entityManager.merge(b));
    }
}
