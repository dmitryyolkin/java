package com.yolkin.springbootdemo;

import com.yolkin.springbootdemo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface ReadingListRepository extends JpaRepository<Book, Long> {

    // implementation will be generated automatically in runtime
    // based on methods' names conventions used by SpringData module
    @Nullable
    List<Book> findByReader(String reader);

}
