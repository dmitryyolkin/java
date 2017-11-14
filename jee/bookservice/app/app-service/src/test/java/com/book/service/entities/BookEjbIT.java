package com.book.service.entities;

import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (13.11.17)
 */
public class BookEjbIT {
    @Test
    public void shouldCreateABook() throws Exception {
        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));

        try (EJBContainer ec = EJBContainer.createEJBContainer(properties)) {
            Context ctx = ec.getContext();

            // Проверяет зависимости JNDI (источники данных и EJB)
            assertNotNull(ctx.lookup("java:global/jdbc/bookServiceDS"));
            assertNotNull(ctx.lookup("java:global/classes/BookEjb!com.book.service.entities.BookEjbRemote"));
            assertNotNull(ctx.lookup("java:global/classes/BookEjb!com.book.service.entities.BookEjb"));

            // Ищет EJB
            BookEjb bookEJB = (BookEjb) ctx.lookup("java:global/classes/BookEjb!com.book.service.entities.BookEjb");

            // Ищет все книги и убеждается, что их две (они добавлены
            // в базу с помощью DBPopulator)
            assertEquals(2, bookEJB.findBooks().size());

            // Создает книгу
            Book book = new Book(
                    "H2G2",
                    12.5F,
                    "Научная фантастика",
                    "1-24561-799-0",
                    354, false
            );

            // Сохраняет книгу в базе данных
            book = bookEJB.create(book);
            assertNotNull("ID не может быть пустым", book.getId());

            // Ищет все книги и убеждается, что их стало на одну больше
            assertEquals(3, bookEJB.findBooks().size());

            // Удаляет созданную книгу   351
            bookEJB.delete(book);

            // Ищет все книги и убеждается, что их стало на одну меньше
            assertEquals(2, bookEJB.findBooks().size());
        }
    }
}
