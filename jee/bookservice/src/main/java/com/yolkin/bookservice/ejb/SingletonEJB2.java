/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice.ejb;

import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * SingletonEJB2
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-07-26 08:08)
 */
@Singleton
@DependsOn("SingletonEJB1")
@Startup
public class SingletonEJB2 {

    public void init(){
    };

}