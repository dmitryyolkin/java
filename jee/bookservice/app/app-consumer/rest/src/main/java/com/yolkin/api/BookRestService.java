package com.yolkin.api;

import com.yolkin.entities.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (27.02.18)
 */
@Path("/book")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class BookRestService {

    @PersistenceContext(unitName = "Rest_PU")
    private EntityManager entityManager;

    @Context
    private UriInfo uriInfo;

    @POST
    public Response createBook(Book book) {
        if (book == null) {
            throw new BadRequestException();
        }

        entityManager.persist(book);
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(book.getId())).build();

        //Respond code 201 with link to a book created recently
        //e.g. URI can be equal smth: http://localhost:8080/chapter15-service-1.0/rs/book/601
        return Response.created(uri).build();
    }

    @GET
    @Path("{id}")
    public Response getBook(@PathParam("id") String bookId) {
        if (bookId == null) {
            throw new BadRequestException("Book id is null");
        }

        Book book = entityManager.find(Book.class, Long.valueOf(bookId));
        if (book == null) {
            throw new NotFoundException("Book with id: " + bookId + " is not found");
        }

        //return code 200
        //and book
        return Response.ok(book).build();
    }

    @GET
    public Response getBooks() {
        TypedQuery<Book> query = entityManager.createNamedQuery(Book.FIND_ALL, Book.class);
        Books books = new Books(query.getResultList());

        //return code = 200
        //And all books saved in DB
        return Response.ok(books).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String bookId) {
        if (bookId == null) {
            throw new BadRequestException("Book id is null");
        }

        Book book = entityManager.find(Book.class, Long.valueOf(bookId));
        if (book == null) {
            throw new NotFoundException("Book with id: " + bookId + " is not found");
        }

        entityManager.remove(book);

        //return code = 204 - no content
        return Response.noContent().build();
    }
}
