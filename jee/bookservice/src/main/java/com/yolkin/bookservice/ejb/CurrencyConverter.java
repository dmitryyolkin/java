/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice.ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-08-04 07:18)
 */
@Stateless
public class CurrencyConverter {
    @Resource(name = "dollar2RubMultiplier")
    private Double dollar2RubMultiplier;

    public Double dollarToRub(double d) {
        return dollar2RubMultiplier * d;
    }

}