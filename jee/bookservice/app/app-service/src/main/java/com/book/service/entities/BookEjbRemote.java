package com.book.service.entities;

import javax.ejb.Remote;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (10.10.17)
 */
@Remote
public interface BookEjbRemote {
    Book findById(Long id);

    List<Book> findBooks();

    @NotNull
    Book create(@NotNull Book b);

    @NotNull
    Book update(@NotNull Book b);

    void delete(@NotNull Book b);
}
