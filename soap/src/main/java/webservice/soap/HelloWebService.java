
package webservice.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * HelloWebService
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2016-01-14 07:42)
 */
// говорим, что наш интерфейс будет работать как веб-сервис
@WebService
// говорим, что веб-сервис будет использоваться для вызова методов
// RPC значит, что wdsl схема будет сформирована автоматически по сигнатуре методов
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWebService {

    @WebMethod
    public String getHello(String name);
}