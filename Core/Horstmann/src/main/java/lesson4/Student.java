package lesson4;/**
 * Created by Sergey Zhernovoy on 20.06.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Student implements Person,Named {
    private static final Logger LOGGER = LoggerFactory.getLogger(Student.class);


    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.getDescription());
    }

    @Override
    public String getDescription() {
        return Person.super.getDescription();
    }
}
