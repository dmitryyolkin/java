package com.yolkin.springbootdemo;

import com.yolkin.springbootdemo.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class ReadingListController {
    private final ReadingListRepository repository;

    @Autowired
    public ReadingListController(ReadingListRepository repository) {
        this.repository = repository;
    }

    // e.g. http://localhost:8080/john.smith
    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String getBooksByReader(
            @PathVariable("reader") String reader,
            Model model) {

        List<Book> books = repository.findByReader(reader);
        if (books != null) {
            model.addAttribute("books", books);
        }

        // return name of View that should be shown
        return "readingList";
    }

    // e.g. http://localhost:8080/john.smith
    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addBoo2ReadingList(
            @PathVariable("reader") String reader,
            Book book) {

        book.setReader(reader);
        repository.save(book);

        // redirect to reader's page
        // it's handled with another controller -
        return "redirect:/{reader}";
    }
}
