package javabean_di_approach;/**
 * @author Sergey Zhernovoy
 * create on 06.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Truba implements Instrument {
    private static final Logger logger = LoggerFactory.getLogger(Truba.class);

    @Override
    public void play() {
        System.out.println("I play na TRUBA");
    }
}

    