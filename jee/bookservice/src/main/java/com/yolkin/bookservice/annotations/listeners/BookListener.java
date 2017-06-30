/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice.annotations.listeners;

import com.yolkin.bookservice.Book;
import javax.persistence.PostLoad;
import java.util.logging.Logger;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-06-30 08:13)
 */
public class BookListener {
    private static final Logger LOGGER = Logger.getLogger(BookListener.class.getName());

    @PostLoad
    public void bookListen(Book book) {
        LOGGER.info("============Book listener (Postload) =======: " + book);
    }

}