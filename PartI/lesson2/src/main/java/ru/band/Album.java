package ru.band;/**
 * Created by Sergey on 02.05.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

public class Album {
    private static final Logger logger = LoggerFactory.getLogger(Album.class);
    private String name;
    private List<Sing> tracks;
    private List<Musician> musicians;

}
