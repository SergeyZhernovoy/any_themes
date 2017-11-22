package spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import spring_boot.entity.Book;
import spring_boot.entity.Isbn;
import spring_boot.entity.Reviewers;
import spring_boot.repositories.BookRepository;
import spring_boot.utils.IsbnEditor;

import java.util.List;

/**
 * @author Sergey Zhernovoy
 * create on 22.11.2017.
 */

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Isbn.class, new IsbnEditor());
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Iterable<Book> getAllBook(){
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Isbn isbn){
        return bookRepository.findBookByIsbn(isbn.getIsbn());
    }

    @RequestMapping(value = "/{isbn}/reviewers", method = RequestMethod.GET)
    public List<Reviewers> getAllReviewers(@PathVariable("isbn") Book book){
        return book.getReviewers();
    }

}

    