package todo;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitry on 11.02.16.
 * It's test home projects
 */
@Path("/todos")
public class TodosResource {
    // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;

    @Context
    Request request;

    // Return the list of todos to the user in the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Todo> getTodosBrowser(){
        return _getTodos();
    }


    // Return the list of todos for applications
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Todo> getTodos(){
        return _getTodos();
    }

    private List<Todo> _getTodos() {
        return  new ArrayList<>(TodoDao.getInstance().getTodos().values());
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount(){
        return String.valueOf(TodoDao.getInstance().getTodos().size());
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void createTodo(
            @FormParam("id") String id,
            @FormParam("summary") String summary,
            @FormParam("description") String description,
            @Context HttpServletResponse servletResponse
    ) throws IOException {
        Integer intId = Integer.valueOf(id);
        Todo todo = new Todo(
                intId,
                summary,
                description
        );
        TodoDao.getInstance().getTodos().put(intId, todo);
        servletResponse.sendRedirect("../todos.html");
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void createTodoWithJSON(Todo todo) throws IOException {
        TodoDao.getInstance().getTodos().put(todo.getId(), todo);
    }

    @Path("{todo}")
    public TodoResource getTodo(@PathParam("todo") String id){
        return new TodoResource(
                uriInfo,
                request,
                Integer.valueOf(id)
        );
    }

}
