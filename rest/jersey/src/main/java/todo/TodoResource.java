package todo;

import com.sun.jersey.server.impl.container.servlet.JerseyServletContainerInitializer;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;
import java.util.Map;

/**
 * Created by dmitry on 10.02.16.
 * It's test home projects
 */
public class TodoResource {

    private UriInfo uriInfo;
    private Request request;
    private int id;

    TodoResource(UriInfo uriInfo, Request request, int id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    //Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Todo getTodo(){
        return _getTodo();
    }

    // for the browser
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Todo getTodoHTML(){
        return _getTodo();
    }

    private Todo _getTodo() {
        Todo todo = TodoDao.getInstance().getTodos().get(id);
        if (todo == null){
            throw new RuntimeException("No todo with id: " + id);
        }
        return todo;
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.TEXT_HTML})
    public Response putTodo(JAXBElement<Todo> todo) {
        Todo c = todo.getValue();
        return putAndGetResponse(c);
    }

    @DELETE
    public void deleteTodo() {
        Todo c = TodoDao.getInstance().getTodos().remove(id);
        if(c==null)
            throw new RuntimeException("Delete: Todo with " + id +  " not found");
    }

    private Response putAndGetResponse(Todo todo) {
        Response res;
        Map<Integer, Todo> todos = TodoDao.getInstance().getTodos();
        if(todos.containsKey(todo.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        todos.put(todo.getId(), todo);
        return res;
    }

}
