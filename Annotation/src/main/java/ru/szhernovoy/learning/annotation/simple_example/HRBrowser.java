package ru.szhernovoy.learning.annotation.simple_example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 02.07.2017.
 */
public class HRBrowser {

    @MyJDBCExecutor(sqlStatment = "select * from employeer")
    public List<Employee> getEmployeer(){

        return new ArrayList<>();

    }

    @MyJDBCExecutor(sqlStatment = "UPDATE *",transactionRequired = true, notifyOnUpdates = true)
    public boolean updateDate(){
        return true;
    }

}
