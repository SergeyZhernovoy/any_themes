package spring_boot.formatters;/**
 * @author Sergey Zhernovoy
 * create on 22.11.2017.
 */

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import spring_boot.entity.Book;
import spring_boot.repositories.BookRepository;

import java.text.ParseException;
import java.util.Locale;

@AllArgsConstructor
public class BookFormater implements Formatter<Book>{
    private static final Logger logger = LoggerFactory.getLogger(BookFormater.class);
    private BookRepository bookRepository;

    @Override
    public Book parse(String bookIdentifier, Locale locale) throws ParseException {
        Book book = bookRepository.findBookByIsbn(bookIdentifier);
        return book != null ? book : bookRepository.findOne(Long.valueOf(bookIdentifier));
    }

    @Override
    public String print(Book book, Locale locale) {
        return book.getIsbn();
    }
}

    