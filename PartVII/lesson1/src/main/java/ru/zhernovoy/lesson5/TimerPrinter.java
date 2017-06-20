package ru.zhernovoy.lesson5;/**
 * Created by Sergey Zhernovoy on 20.06.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class TimerPrinter implements ActionListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimerPrinter.class);

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone , the time is "+new Date());
        Toolkit.getDefaultToolkit().beep();
    }

    public static void main(String[] args) {
        ActionListener listener = new TimerPrinter();
        Timer timer = new Timer(1000,listener);
        timer.start();
        JOptionPane.showMessageDialog(null,"Quit programm ?");
        System.exit(0);
    }
}
