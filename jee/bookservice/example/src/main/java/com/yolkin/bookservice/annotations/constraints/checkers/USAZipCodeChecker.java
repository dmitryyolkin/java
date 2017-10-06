/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice.annotations.constraints.checkers;

import com.yolkin.bookservice.annotations.qualifiers.USA;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-05-18 07:54)
 */
@USA
public class USAZipCodeChecker implements ZipCodeChecker{

    @Override
    public boolean isZipCodeValid(String value) {
        return true;
    }
}