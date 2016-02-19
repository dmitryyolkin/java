package hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by dmitry on 02.02.16.
 * It's test home projects
 */
@Path("/hello")
public class HelloService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String hello(){
        String result = "@Produces(\"application/xml\") Output: \n\nHello Output: \n\n";
        return "<helloService>" + "<helloinput>" + "" + "</helloinput>" + "<hellooutput>" + result + "</hellooutput>" + "</helloService>";
    }

    @Path("{n}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String hello(@PathParam("n") String name) {

        String result = "@Produces(\"application/xml\") Output: \n\nHello Output: \n\n" + name + "!!!";
        return "<helloService>" + "<helloinput>" + name + "</helloinput>" + "<hellooutput>" + result + "</hellooutput>" + "</helloService>";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String plainHello(){
        return "hello";
    }
}
