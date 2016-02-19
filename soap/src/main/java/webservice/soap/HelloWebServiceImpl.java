/*
* Copyright (c) 2008-2016 Maxifier Ltd. All Rights Reserved.
*/
package webservice.soap;

import javax.jws.WebService;

/**
 * HelloWebServiceImpl
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2016-01-14 07:56)
 */

// но здесь используется с параметром endpointInterface,
// указывающим полное имя класса интерфейса нашего веб-сервиса
@WebService(endpointInterface = "webservice.soap.HelloWebService")
public class HelloWebServiceImpl implements HelloWebService {

    @Override
    public String getHello(String name) {
        return "Hello " + name + ";";
    }
}