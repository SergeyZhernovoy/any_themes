package spring_boot.bookpub;/**
 * @author Sergey Zhernovoy
 * create on 20.11.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import spring_boot.entity.Author;
import spring_boot.entity.Book;
import spring_boot.entity.Publisher;
import spring_boot.repositories.AuthorRepository;
import spring_boot.repositories.BookRepository;
import spring_boot.repositories.PublisherRepository;
import spring_boot.repositories.ReviewersRepository;

import javax.sql.DataSource;

public class StartupRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(StartupRunner.class);

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    ReviewersRepository reviewersRepository;

    @Qualifier("dataSource")
    @Autowired
    private DataSource ds;



    @Override
    public void run(String... args) throws Exception {
        logger.info("Hello");
        logger.info("DataSource: "+ ds.toString());

        Author author = new Author("Sergey","Zhernovoy");
        authorRepository.save(author);

        Publisher publisher = new Publisher("Pact");
        publisherRepository.save(publisher);

        Book book =new Book("978-1-78528-415-1","Spring Boot Recipes","This book about Spring Boot",author,publisher);
        bookRepository.save(book);

    }

    @Scheduled(initialDelay = 2000, fixedRate = 10000)
    public void run(){
        logger.info("Number of book: "+ bookRepository.count());
    }
}

    