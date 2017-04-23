package ru.szhernov.car.controllers;/**
 * @author Sergey Zhernovoy
 * create on 10.04.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CarController {
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public static void main(String[] args) {
        CarController carController = new CarController();
        CarController carController1 = new CarController();
        carController.setStr("Test");
        carController1.setStr(null);

        System.out.println(carController.getStr().equals(carController1.getStr()));
    }
}

    