package ru.zhernovoy.lesson4;/**
 * Created by Sergey Zhernovoy on 20.06.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Arrays;

public class Student implements Person,Named {
    private static final Logger LOGGER = LoggerFactory.getLogger(Student.class);


    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.getDescription("1","2","3"));
    }

}
