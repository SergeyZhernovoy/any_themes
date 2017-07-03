package ru.szhernovoy.learning.annotation.lesson1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Sergey on 01.07.2017.
 */

@Target({ElementType.METHOD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.SOURCE)
public @interface MyJDBCExecutor {
    String sqlStatment();
    boolean transactionRequired() default false;
    boolean notifyOnUpdates() default false;
}
