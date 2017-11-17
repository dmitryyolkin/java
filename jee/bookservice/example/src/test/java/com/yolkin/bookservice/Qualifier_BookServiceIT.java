/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-04-17 07:21)
 */
public class Qualifier_BookServiceIT {

    @Test
    public void test(){
        Weld weld = new Weld();

        // with 2.2 weld treats the two beans.xml files as two separate archives.
        // To have test alternative override that we need to switch off this feature
        System.setProperty(Weld.ARCHIVE_ISOLATION_SYSTEM_PROPERTY, "false");
        WeldContainer container = weld.initialize();

        BookService bookService = container.instance().select(BookService.class).get();

        Book book = bookService.createBook("test", 1.f, "test desc");
        Assert.assertTrue(book.getNumber().startsWith("MOCK"));

        container.shutdown();
    }

}