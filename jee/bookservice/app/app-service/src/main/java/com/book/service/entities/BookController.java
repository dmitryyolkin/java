package com.book.service.entities;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (19.12.17)
 */
@Named
@RequestScoped
public class BookController {
    @Inject
    private BookEjb bookEJB;
    private Book book = new Book();

    public String doCreateBook() {
        bookEJB.create(book);
        FacesContext
                .getCurrentInstance()
                .addMessage(
                        null,
                        new FacesMessage(
                                FacesMessage.SEVERITY_INFO,
                                "Book created",
                                "Книга" + book.getTitle() + " была создана с id=" + book.getId()
                        )
                );
        return "newBook.xhtml";
    }

    public void doFindBookById() {
        book = bookEJB.findById(book.getId());
    }

    // Методы работы со свойствами
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}