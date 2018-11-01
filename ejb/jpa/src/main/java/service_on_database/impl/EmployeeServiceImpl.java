package service_on_database.impl;

import entities.Employee;
import service_on_database.EmployeeService;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.stream.Stream;

public class EmployeeServiceImpl implements EmployeeService {

    EntityManager em;

    public EmployeeServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Employee create(int id, String name, long salary) {
        Employee emp = new Employee(id);
        emp.setName(name);
        emp.setSalary(salary);
        em.persist(emp);
        return emp;
    }

    @Override
    public Employee find(int id) {
        Employee emp = em.find(Employee.class, id);
        return emp;
    }

    @Override
    public void delete(int id) {
        Employee emp = em.find(Employee.class, id);
        if (emp != null) {
            em.remove(emp);
        }
    }

    @Override
    public Employee updateSalary(int id, long salary) {
        Employee emp = em.find(Employee.class, id);
        if (emp != null) {
            emp.setSalary(emp.getSalary() + salary);
        }
        return emp;
    }

    @Override
    public Stream<Employee> getAll() {
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
        Stream<Employee> employeers = query.getResultStream();
        return employeers;
    }



}

