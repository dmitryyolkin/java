package com.yolkin.api;

import com.yolkin.entities.Book;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (26.02.18)
 */
@XmlRootElement
@XmlSeeAlso(Book.class)
public class Books extends ArrayList<Book>{

    public Books(int initialCapacity) {
        super(initialCapacity);
    }

    public Books(Collection<? extends Book> c) {
        super(c);
    }

    @XmlElement(name = "book")
    public List<Book> getBooks() {
        return this;
    }

    public void setBooks(List<Book> books){
        this.addAll(books);
    }
}
