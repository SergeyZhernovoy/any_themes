package spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring_boot.entity.Book;
import spring_boot.repositories.BookRepository;

/**
 * @author Sergey Zhernovoy
 * create on 22.11.2017.
 */

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Iterable<Book> getAllBook(){
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
    public Book getBook(@PathVariable String isbn){
        return bookRepository.findBookByIsbn(isbn);
    }

}

    