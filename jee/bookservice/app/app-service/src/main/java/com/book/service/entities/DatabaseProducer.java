package com.book.service.entities;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (16.10.17)
 */
public class DatabaseProducer {
    @Produces
    @PersistenceContext(unitName = "bookService")
    private EntityManager entityManager;
}
