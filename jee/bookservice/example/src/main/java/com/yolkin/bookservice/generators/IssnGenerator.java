/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice.generators;

import com.yolkin.bookservice.annotations.qualifiers.EightDigits;
import com.yolkin.bookservice.annotations.interceptors.Loggable;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-04-17 07:31)
 */
@EightDigits
public class IssnGenerator implements NumberGenerator{

    @Inject
    private Logger logger;

    @Override
    @Loggable
    public String generateNumber() {
        String issn = "8-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован ISBN : " + issn);
        return issn;
    }
}