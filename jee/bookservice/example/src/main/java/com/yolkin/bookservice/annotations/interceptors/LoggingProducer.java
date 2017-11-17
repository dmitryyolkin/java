/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice.annotations.interceptors;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

/**
 * LoggingProducer is needed because java.util.logging.Logger is not injectable (it's in rt.jar which doesn't contain  beans.xml)
 * So we use this class to produce injectable Logger
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-04-17 07:56)
 */
public class LoggingProducer {

    @Produces
    public Logger createLogger(InjectionPoint injectionPoint){
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}