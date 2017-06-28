package fx;/**
 * Created by Sergey on 08.04.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Employee {
    private static final Logger logger = LoggerFactory.getLogger(Employee.class);

    private String name;
    private double salary;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        double oldSalary = this.salary;
        this.salary = newSalary;
        pcs.firePropertyChange("salary",oldSalary,newSalary);

    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        pcs.removePropertyChangeListener(propertyChangeListener);
    }

    public void addPropertCHangeListiner(PropertyChangeListener propertyChangeListener) {
        pcs.addPropertyChangeListener(propertyChangeListener);
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
