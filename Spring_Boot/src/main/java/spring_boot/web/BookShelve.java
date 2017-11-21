package spring_boot.web;/**
 * @author Sergey Zhernovoy
 * create on 21.11.2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring_boot.repositories.BookRepository;

@Controller
public class BookShelve {
    @Autowired
    private BookRepository bookRepository;
}

    