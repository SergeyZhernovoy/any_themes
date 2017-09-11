package example_by_2;/**
 * @author Sergey Zhernovoy
 * create on 06.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;

public class ThreadSafe {
    private static final Logger logger = LoggerFactory.getLogger(ThreadSafe.class);

    public static void main(String[] args) {
        ThreadLocal<DateFormatter> dateFormatterThreadLocal = ThreadLocal
                            .withInitial(()->new DateFormatter(new SimpleDateFormat("dd-MM-yyyy")));
    }
}

    