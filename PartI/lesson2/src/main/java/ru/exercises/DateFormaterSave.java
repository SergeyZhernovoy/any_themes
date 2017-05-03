package ru.exercises;/**
 * Created by Sergey on 03.05.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;

public class DateFormaterSave {
    private static final Logger logger = LoggerFactory.getLogger(DateFormaterSave.class);
    private ThreadLocal<DateFormatter> dateFormatterThreadLocal;
    public DateFormaterSave(){
        dateFormatterThreadLocal = ThreadLocal.withInitial(()-> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));

    }

    public void TestButton(){
        JButton button = new JButton();
        button.addActionListener(event -> System.out.println(event.getActionCommand()));
    }

    public static void main(String[] args) {

    }

}
