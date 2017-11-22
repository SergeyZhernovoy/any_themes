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
import spring_boot.repositories.BookRepository;

import javax.sql.DataSource;

public class StartupRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(StartupRunner.class);

    @Autowired
    private BookRepository bookRepository;

    @Qualifier("dataSource")
    @Autowired
    private DataSource ds;



    @Override
    public void run(String... args) throws Exception {
        logger.info("Hello");
        logger.info("DataSource: "+ ds.toString());

    }

    @Scheduled(initialDelay = 2000, fixedRate = 10000)
    public void run(){
        logger.info("Number of book: "+ bookRepository.count());
    }
}

    