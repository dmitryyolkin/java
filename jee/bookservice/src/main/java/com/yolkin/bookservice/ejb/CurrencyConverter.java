/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice.ejb;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-08-04 07:18)
 */
@Stateless
@LocalBean
public class CurrencyConverter implements
        CurrencyConverterLocal,
        CurrencyConverterRemote{
    @Resource(name = "dollar2RubMultiplier")
    private Double dollar2RubMultiplier;

    @Override
    public Double dollarToRub(Double d) {
        return dollar2RubMultiplier * d;
    }

}