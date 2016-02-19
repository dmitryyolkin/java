/*
* Copyright (c) 2008-2016 Maxifier Ltd. All Rights Reserved.
*/
package webservice.soap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * HelloWebServiceClient
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2016-01-14 08:22)
 */
public class HelloWebServiceClient {

    public static void main(String[] args) throws MalformedURLException {
        // создаем ссылку на wsdl описание
        URL url = new URL("http://localhost:1986/wss/hello?wsdl");

        // Параметры следующего конструктора смотрим в самом первом теге WSDL описания - definitions
        // 1-ый аргумент смотрим в атрибуте targetNamespace
        // 2-ой аргумент смотрим в атрибуте name
        QName qName = new QName("http://soap.webservice/", "HelloWebServiceImplService");

        // Теперь мы можем дотянуться до тега service в wsdl описании,
        Service service = Service.create(url, qName);

        // а далее и до вложенного в него тега port, чтобы
        // получить ссылку на удаленный от нас объект веб-сервиса
        HelloWebService helloWebService = service.getPort(HelloWebService.class);
        System.out.println(helloWebService.getHello("Dima"));
    }

}