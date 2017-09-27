/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice.ejb;

import javax.ejb.Local;

/**
 * CurrencyConverterLocal
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-08-09 07:52)
 */
@Local
public interface CurrencyConverterLocal {

    Double dollarToRub(Double d);

}