/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice;

import com.yolkin.bookservice.annotations.interceptors.Loggable;
import com.yolkin.bookservice.annotations.qualifiers.ThirteenDigits;
import com.yolkin.bookservice.generators.NumberGenerator;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * MockGenerator is Alternative and mock of NumberGenerator.
 * Alternative can be injected only if it's explicitly specified in beans.xml
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-04-17 07:33)
 */
@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator{

    @Inject
    private Logger logger;

    @Override
    @Loggable
    public String generateNumber() {
        String mock = "MOCK-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован Mock : " + mock);
        return mock;
    }
}