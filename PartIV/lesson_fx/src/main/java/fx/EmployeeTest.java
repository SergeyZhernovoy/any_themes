package fx;/**
 * Created by Sergey on 08.04.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.beans.PropertyChangeEvent;

public class EmployeeTest {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeTest.class);

    public static void main(String[] args) {
        final Employee employee = new Employee("Sergey",10000);
        complexTax(employee.getSalary());
        employee.addPropertCHangeListiner(EmployeeTest::handlePropertyChange);
        employee.setSalary(3000);
        employee.setSalary(5000);
        employee.setSalary(7000);

    }

    public static void handlePropertyChange(PropertyChangeEvent event){
        String propertyName = event.getPropertyName();
        if("salary".equals(propertyName)){
            System.out.println("Salary change");
            System.out.println("Old salary:"+ event.getOldValue());
            System.out.println("New value"+ event.getNewValue());
            complexTax((Double) event.getNewValue());
        }
    }

    public static void complexTax(double salary){
            final double taxPercent = 2.0;
            double tax = salary * taxPercent / 100.0;
        System.out.println("Salary: "+ salary + " Tax:"+ tax);
    }

}
