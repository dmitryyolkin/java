/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice.generators;

import com.yolkin.bookservice.annotations.Loggable;
import com.yolkin.bookservice.annotations.ThirteenDigits;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-04-17 07:28)
 */
// @ThirteenDigits - is qualifier that allows injector to inject correct implementation
@ThirteenDigits
public class IsbnGenerator implements NumberGenerator{

    @Inject
    private Logger logger;

    @Override
    @Loggable //allows to intercept this method and log about its execution
    public String generateNumber() {
        String isbn = "13-84356-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован ISBN : " + isbn);
        return isbn;
    }
}