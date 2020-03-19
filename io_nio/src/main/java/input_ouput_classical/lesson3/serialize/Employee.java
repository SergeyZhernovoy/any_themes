package input_ouput_classical.lesson3.serialize;

import java.io.Serializable;

/**
 * @author Sergey Zhernovoy
 * create on 15.10.2017.
 */

public class Employee implements Serializable {

    private static final long serialVersionUID = -8279237004489664087L;

    private String name;

    private int age;

    private String vacancy;

    private transient char[] password;

    public Employee(String name, int age, String vacancy) {
        this.name = name;
        this.age = age;
        this.vacancy = vacancy;
    }

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

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
}

    