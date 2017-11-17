package com.book.service;

import com.book.service.entities.Book;
import com.book.service.entities.BookEjbRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (17.11.17)
 */
public class BookMain {
    public static void main(String[] args) throws NamingException {

        //looking for EJB
        InitialContext ctx = new InitialContext();

        // *** Important
        // In comparison with BookEjbIT where we specify JNDI name as java:global/classes...
        // In this case we have to refer to application name deployed on Application server smth like
        // java:global/app-service-1.0-SNAPSHOT..
        BookEjbRemote bookEjb = (BookEjbRemote) ctx.lookup("java:global/app-service-1.0-SNAPSHOT/BookEjb!com.book.service.entities.BookEjbRemote");

        //Get all books from DB
        List<Book> books = bookEjb.findBooks();
        for (Book book : books) {
            System.out.println(book);
        }

        //all other BookEjb methods can be invoked below
    }
}
