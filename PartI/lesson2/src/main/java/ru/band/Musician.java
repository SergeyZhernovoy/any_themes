package ru.band;/**
 * Created by Sergey on 01.05.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

public class Musician {
    private static final Logger logger = LoggerFactory.getLogger(Musician.class);
    private String name;
    private List<Musician> members;
    private String origin;

}
