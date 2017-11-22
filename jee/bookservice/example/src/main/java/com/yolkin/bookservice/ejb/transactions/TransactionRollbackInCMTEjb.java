package com.yolkin.bookservice.ejb.transactions;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (22.11.17)
 */
@Stateless
public class TransactionRollbackInCMTEjb {
    @Resource
    private SessionContext cnt;

    public void methodRolledBackWithSetRollbackOnly() {
        if (true) {
            //some check for buisness logic

            //transaction will be rolled back if it's marked with 'setRollbackOnly'
            cnt.setRollbackOnly();
        }
    }

    public void methodRolledBackWithException() throws TransactionRollbackException {
        if (true) {
            //some check for buisness logic

            //transaction will be rolled back if we throw checked Exception annotated with
            //@ApplicationException(rollback = true)
            throw new TransactionRollbackException();
        }
    }

    public void methodRolledBackWithRuntimeException() {
        if (true) {
            //some check for buisness logic

            //transaction will be rolled back if we throw Unchecked Exception
            //or the exception is RemoteException
            throw new RuntimeException();
        }
    }


}
