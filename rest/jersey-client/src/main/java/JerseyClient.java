

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



/**
 * Created by dmitry on 09.02.16.
 * It's test home projects
 */
public class JerseyClient {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080");

        Response responseAll = target
                .path("rest-jersey")
                .path("hello")
                .request()
                .accept(MediaType.APPLICATION_XML)
                .get(Response.class);

        String stringReply = target
                .path("rest-jersey")
                .path("hello")
                .queryParam("n", "Dmitry")
                .request()
                .accept(MediaType.APPLICATION_XML)
                .get(String.class);

        System.out.println(responseAll + " message: " + responseAll.readEntity(String.class));
        System.out.println(stringReply);
    }
}
