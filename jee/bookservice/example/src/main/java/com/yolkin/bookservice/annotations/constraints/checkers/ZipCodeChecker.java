/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice.annotations.constraints.checkers;

/**
 * It checks physical Zip Code existence
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-05-18 07:53)
 */
public interface ZipCodeChecker {

    boolean isZipCodeValid(String value);

}