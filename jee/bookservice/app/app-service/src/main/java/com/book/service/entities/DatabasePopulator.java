package com.book.service.entities;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (16.10.17)
 */
@Singleton
@Startup
@DataSourceDefinition(
        //@DataSourceDefinition specifies Data Source properties
        //like access to DB and so on


        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/bookServiceDS",
        user = "APP",
        password = "APP",
        databaseName = "bookService",
        properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    @Inject
    private BookEjb bookEjb;

    private Book book1;
    private Book book2;

    @PostConstruct
    private void populateDB() {
        book1 = bookEjb.create(new Book(
                "Book1",
                1.0f,
                "Book1 description",
                "0-0000-0000-1",
                100, true
        ));

        book2 = bookEjb.create(new Book(
                "Book2",
                2.0f,
                "Book2 description",
                "0-0000-0000-2",
                200, true
        ));
    }

    @PreDestroy
    private void clearDB() {
        bookEjb.delete(book1);
        bookEjb.delete(book2);
    }
}
