/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice.ejb;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-08-04 07:42)
 */
public class EJBLocalRunner {

    public static void main(String[] args) throws NamingException {
        //todo it doesn't work (CurrencyConverter.dollarToRub(..) can not be found)
        //but what is interesting if it work if I copy CurrencyConverter and its registration into ejb-jar.xml
        //to initial author's environment
        //https://github.com/agoncal/agoncal-book-javaee7/tree/master/chapter07/chapter07-samples/src/main

        Map<String, Object> props = new HashMap<>();
        props.put(EJBContainer.MODULES, new File("target/classes"));

        try (EJBContainer ejbContainer = EJBContainer.createEJBContainer(props)) {
            Context cx = ejbContainer.getContext();
            CurrencyConverter currencyConverter = (CurrencyConverter) cx.lookup("java:global/classes/CurrencyConverter!com.yolkin.bookservice.ejb.CurrencyConverter");
            System.out.println("Conversion result: " + currencyConverter.dollarToRub(1.0));
        }
    }

}