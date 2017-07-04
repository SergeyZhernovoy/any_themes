package ru.szhernovoy.learning.annotation.lesson2;/**
 * @author Sergey Zhernovoy
 * create on 04.07.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class Inherited extends Parent {
    private static final Logger logger = LoggerFactory.getLogger(Inherited.class);

    @Override
    public String anyMethod() {
        return "Method child";
    }

    @Override
    public void method(){

    }


}

    