package service_on_database;

import entities.Employee;

import java.util.stream.Stream;

public interface EmployeeService {
    Employee create(int id, String name, long salary);
    Employee find(int id);
    void delete(int id);
    Employee updateSalary(int id, long salary);
    Stream<Employee> getAll();
}
