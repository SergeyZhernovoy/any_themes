package ru.szhernovoy.test.controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sergey Zhernovoy
 *         create on 26.06.2017.
 */
public class LoginControllerTest {

    @Before
    public void startMessage(){
        System.out.println("\n[:]\t\t\t\tLet's start test it\t\n");
    }

    @After
    public void endMessage(){
        System.out.println("\n[:]\t\t\t\t\tEnd test\t");
    }

    @Test
    public void whenWeStartAppWeGetLoginPageFirst() throws Exception {
        System.out.println("Test");
    }

    @Test
    public void whenPutRigthInformationThenGiveGreetingMessage() throws Exception {

    }





}