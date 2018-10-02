package ru.initial;


import javax.ejb.Stateless;

@Stateless
public class HelloUserBean implements HelloUser{
    @Override
    public String sayHello(String name) {
        return String.format("Hello %s welcome to EJB 3.1!", name);
    }

}
