/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice;

import com.yolkin.bookservice.annotations.interceptors.Loggable;
import com.yolkin.bookservice.annotations.qualifiers.ThirteenDigits;
import com.yolkin.bookservice.generators.NumberGenerator;
import javax.inject.Inject;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-04-17 07:23)
 */
@Loggable
public class BookService {

    @Inject @ThirteenDigits
    private NumberGenerator numberGenerator;

    public Book createBook(String title, Float price, String description){
        return new Book(
                title, price, description,
                numberGenerator.generateNumber()
        );
    }
}