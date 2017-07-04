package ru.szhernovoy.learning.annotation.lesson2;/**
 * @author Sergey Zhernovoy
 * create on 04.07.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Parent {
    private static final Logger logger = LoggerFactory.getLogger(Parent.class);
    public String anyMethod(){
        return "Hello world !";
    }

    @Deprecated
    public void method(){
        System.out.println("Override");
    }

}

    