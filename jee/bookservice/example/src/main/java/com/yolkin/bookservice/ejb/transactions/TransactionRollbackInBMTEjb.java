package com.yolkin.bookservice.ejb.transactions;

import com.yolkin.bookservice.BookService;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.Random;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (22.11.17)
 */
@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class TransactionRollbackInBMTEjb {
    @PersistenceContext(unitName = "BookService_PU")
    private EntityManager entityManager;

    @EJB
    private BookService bookService;

    @Resource
    private UserTransaction transaction;

    public void execute() {
        try {
            transaction.begin();
            bookService.createBook(
                    "title" + new Random().nextInt(),
                    2.0f,
                    "Some test stuff"
            );
            transaction.commit();
        } catch (Exception e) {
            try {
                transaction.rollback();
            } catch (SystemException e1) {
                throw new RuntimeException("Some system error " + e1);
            }
        }
    }


}
