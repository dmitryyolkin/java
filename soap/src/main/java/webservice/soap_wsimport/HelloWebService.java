
package webservice.soap_wsimport;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloWebService", targetNamespace = "http://soap_wsimport.webservice/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWebService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://soap_wsimport.webservice/HelloWebService/getHelloRequest", output = "http://soap_wsimport.webservice/HelloWebService/getHelloResponse")
    public String getHello(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

}
