package part3_4_5;/**
 * @author Sergey Zhernovoy
 * create on 08.08.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

public class EmployeeList {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeList.class);
    private Employee[] employees = new Employee[10];

    private class Iterator implements java.util.Iterator {
        private int element = 0;
        @Override
        public boolean hasNext() {
            return element < employees.length;
        }

        @Override
        public Employee next() {
            if(hasNext()){
               return employees[element++];
            } else throw new NoSuchElementException();

        }
    }

    public java.util.Iterator getIterator(){
        return new Iterator();
    }

}


    