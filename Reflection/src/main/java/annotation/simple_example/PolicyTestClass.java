package annotation.simple_example;

import java.io.IOException;

/**
 * @author Sergey Zhernovoy
 * create on 06.07.2017.
 */

public class PolicyTestClass {

    @TestCase(willThrow = IOException.class)
    public static void testCase1(){
        System.out.println("Exception call ");
    }
}

    