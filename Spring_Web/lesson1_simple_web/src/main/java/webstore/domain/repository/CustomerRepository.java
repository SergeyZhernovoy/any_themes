package webstore.domain.repository;

import webstore.domain.Customer;

import java.util.List;

/**
 * @author Sergey Zhernovoy
 * create on 16.09.2017.
 */

public interface CustomerRepository {

    List<Customer> getAllCustomers();

    void addCustomer(Customer customer);
}

    