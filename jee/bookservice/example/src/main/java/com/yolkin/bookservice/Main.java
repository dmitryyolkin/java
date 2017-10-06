/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import java.util.logging.Logger;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-04-12 07:55)
 */
public class Main {
   public static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        //this code is specific for Weld and can not be ported to
        //other CDI container
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();

        Book book = bookService.createBook("1", 5.0f, "1 - desc");
        logger.info(book.toString());;
        weld.shutdown();

    }

}