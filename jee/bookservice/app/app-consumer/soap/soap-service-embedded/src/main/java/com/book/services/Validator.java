package com.book.services;

import javax.jws.WebService;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (01.02.18)
 */
@WebService
public interface Validator {

    boolean validate(CreditCard creditCard);

}
