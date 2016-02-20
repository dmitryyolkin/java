package hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by dmitry on 20.02.16.
 * It's test home projects
 */
@Path("/message")
public class ResteasyMessageService {

    @GET
    @Path("{p}")
    public Response printMessage(@PathParam("p") String msg){
        //potentially we can return what we need (String, POJO if we support serialization)
        //the same as for Jersey
        return Response.status(200).entity(String.format("Msg: %s", msg)).build();
    }

}
