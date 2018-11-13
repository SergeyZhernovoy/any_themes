package service_bean.impl;

import service_bean.HelloService;

import javax.ejb.Stateless;

@Stateless
public class HelloServiceBean implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
