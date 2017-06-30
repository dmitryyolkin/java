/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice.annotations.listeners;

import javax.persistence.PostLoad;
import java.util.logging.Logger;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-06-30 08:15)
 */
public class CommonDebugListener {
    private static final Logger LOGGER = Logger.getLogger(CommonDebugListener.class.getName());

    @PostLoad
    public void debug(Object o) {
        LOGGER.info("============Common Debug listener (Postload)=======: " + o);
    }
}