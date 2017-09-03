package part9_threads;/**
 * @author Sergey Zhernovoy
 * create on 04.09.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartThreadUI {
    private static final Logger logger = LoggerFactory.getLogger(StartThreadUI.class);

    public static void main(String[] args) {
        Producer producer = new Producer();
        new Thread(producer).start();
        Consumer consumer = new Consumer(producer);
        new Thread(consumer).start();
    }
}

    