/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.logging.Logger;

/**
 * Before run this class look at your persistence.xml and make sure what settings are set for Persistence unit by the class.
 * At the moment we use Derby (embedded version for test and remote for prod)
 *
 * For this class prod version is used and before you will be able to use you have to install Derby server and configure it
 * See details here http://db.apache.org/derby/papers/DerbyTut/ns_intro.html -> Derby Network Server
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-06-06 07:53)
 */
public class JPAMain {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(JPAMain.class.getName());

        Book book = new Book(
                "test",
                20.f,
                "test book",
                "1-84023-742-2"
        );

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookService_PU");
        EntityManager em = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(book);
            transaction.commit();

        } catch (Exception e) {
            logger.severe("Transaction error " + e.getMessage());
            transaction.rollback();
        } finally {
            em.close();
            entityManagerFactory.close();
        }
    }
}