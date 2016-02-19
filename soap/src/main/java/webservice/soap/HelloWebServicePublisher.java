/*
* Copyright (c) 2008-2016 Maxifier Ltd. All Rights Reserved.
*/
package webservice.soap;

import javax.xml.ws.Endpoint;

/**
 * HelloWebServicePublisher
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2016-01-14 07:58)
 */
public class HelloWebServicePublisher {

    public static void main(String[] args) {
        // запускаем веб-сервер на порту 1986
        // и по адресу, указанному в первом аргументе,
        // запускаем веб-сервис, передаваемый во втором аргументе
        Endpoint.publish("http://localhost:1986/wss/hello", new HelloWebServiceImpl());

        //Теперь запустим этот класс, нажав Shift+F10. В консоли ничего не появится, но сервер запущен.
        //В этом можно убедиться набрав в браузере строку http://localhost:1986/wss/hello?wsdl.
    }

}