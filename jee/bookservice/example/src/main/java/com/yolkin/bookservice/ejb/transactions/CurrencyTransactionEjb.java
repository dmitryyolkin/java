package com.yolkin.bookservice.ejb.transactions;

import com.yolkin.bookservice.ejb.CurrencyConverter;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (21.11.17)
 */
@Stateless
@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
public class CurrencyTransactionEjb {
    @Inject
    private CurrencyConverter currencyConverter;

    @TransactionAttribute(value = TransactionAttributeType.NOT_SUPPORTED)
    private void printCurrencyRate() {
        Double rub = currencyConverter.dollarToRub(1.0);
        System.out.println(String.format("%s rub per dollar", rub));
    }
}
