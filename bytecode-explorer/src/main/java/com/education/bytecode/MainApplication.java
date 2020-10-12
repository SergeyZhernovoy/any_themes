package com.education.bytecode;


public class MainApplication {

    public static final String NAME = "Sergey";
    public static final String HI = "hi";
    public static final String OOPS = "!";

    public static void main(String[] args) throws ClassNotFoundException {
//        int i = 0;
//        i = i++ + i++;
//        System.out.println(i);
//
//        try {
//            int a = 1;
//            System.out.println(a / 0);
//
//        } catch (Error e) {
//            System.out.println("Error work");
//        }
//
//
//        String c = NAME;
//        String a = HI + NAME + OOPS;
//        String b = new StringBuilder()
//                .append(HI)
//                .append(NAME)
//                .append(OOPS)
//                .toString();
//        Class<String> type = (Class<String>) Class.forName("java.lang.String");
//        System.out.println(type.getSimpleName());
//        Integer da =1;
//        Long ad = 1L;
//        ad = da.longValue();

        A ha = new B();
        B ah = new B();
        ha.test1("test");
        System.out.println(((B)ha).a);

    }


    static class A {
        int a = 1;
        void test1(Object f) {
            System.out.println(1);
        }
    }

    static class B extends A {
        int a = 2;
        void test1(String v) {
            System.out.println(2);
        }
    }
}
