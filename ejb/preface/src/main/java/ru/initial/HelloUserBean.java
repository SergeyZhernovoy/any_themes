package ru.initial;


import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless
public class HelloUserBean implements HelloUser{
    @Override
    public String sayHello(String name) {
        return String.format("Hello %s welcome to EJB 3.1!", name);
    }

    public static void main(String[] args) throws NamingException {
        Context context = new InitialContext();
        HelloUserBean helloUser = (HelloUserBean) context.lookup("java:module/HelloUserBean");
        helloUser.sayHello("Sergey Zhernovoy");
    }
}
