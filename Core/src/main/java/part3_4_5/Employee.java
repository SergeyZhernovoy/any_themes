package part3_4_5;/**
 * @author Sergey Zhernovoy
 * create on 08.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Employee {
    private static final Logger logger = LoggerFactory.getLogger(Employee.class);
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

    