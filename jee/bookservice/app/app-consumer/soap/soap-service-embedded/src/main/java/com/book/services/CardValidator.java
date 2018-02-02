package com.book.services;

import javax.jws.WebService;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (01.02.18)
 */
@WebService(endpointInterface = "com.book.services.Validator")
public class CardValidator implements Validator {

    // ======================================
    // =           Public Methods           =
    // ======================================

    @Override
    public boolean validate(CreditCard creditCard) {
        Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);
        return Integer.parseInt(lastDigit.toString()) % 2 == 0;
    }
}