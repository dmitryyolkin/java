/*
* Copyright (c) 2008-2016 Maxifier Ltd. All Rights Reserved.
*/
package webservice.soap_wsimport;

import java.net.MalformedURLException;

/**
 * HelloWebServiceClient
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2016-01-14 08:22)
 */
public class HelloWebServiceClient {

    public static void main(String[] args) throws MalformedURLException {
        // подключаемся к тегу service в wsdl описании
        HelloWebServiceImplService helloWebServiceImplService = new HelloWebServiceImplService();

        // получив информацию из тега service подключаемся к самому веб-сервису
        HelloWebService helloWebService = helloWebServiceImplService.getHelloWebServiceImplPort();

        System.out.println(helloWebService.getHello("Dima"));
    }

}