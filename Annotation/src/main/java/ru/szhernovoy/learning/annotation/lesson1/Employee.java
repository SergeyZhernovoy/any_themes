package ru.szhernovoy.learning.annotation.lesson1;

/**
 * Created by Sergey on 02.07.2017.
 */
public class Employee extends Entity{

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
