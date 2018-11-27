package service_on_database.impl;

import entities.Employee;
import service_on_database.EmployeeService;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.stream.Stream;

@Stateful
public class EmployeeServiceImpl implements EmployeeService {

    @PersistenceUnit(unitName = "EmployeeService")
    protected EntityManager em;


    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Employee create(int id, String name, long salary) {
        Employee emp = new Employee(id);
        emp.setName(name);
        emp.setSalary(salary);
        getEntityManager().persist(emp);
        return emp;
    }

    @Override
    public Employee find(int id) {
        Employee emp = getEntityManager().find(Employee.class, id);
        return emp;
    }

    @Override
    public void delete(int id) {
        Employee emp = getEntityManager().find(Employee.class, id);
        if (emp != null) {
            getEntityManager().remove(emp);
        }
    }

    @Override
    public Employee updateSalary(int id, long salary) {
        Employee emp = getEntityManager().find(Employee.class, id);
        if (emp != null) {
            emp.setSalary(emp.getSalary() + salary);
        }
        return emp;
    }

    @Override
    public Stream<Employee> getAll() {
        TypedQuery<Employee> query = getEntityManager().createQuery("SELECT e FROM Employee e", Employee.class);
        Stream<Employee> employeers = query.getResultStream();
        return employeers;
    }



}

