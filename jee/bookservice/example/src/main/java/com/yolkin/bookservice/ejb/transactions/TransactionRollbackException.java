package com.yolkin.bookservice.ejb.transactions;

import javax.ejb.ApplicationException;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (22.11.17)
 */
@ApplicationException(rollback = true)
public class TransactionRollbackException extends Exception{
}
