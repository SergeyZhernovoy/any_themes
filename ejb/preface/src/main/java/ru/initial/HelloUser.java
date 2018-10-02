package ru.initial;

import javax.ejb.Local;

@Local
public interface HelloUser {
    String sayHello(String name);
}
