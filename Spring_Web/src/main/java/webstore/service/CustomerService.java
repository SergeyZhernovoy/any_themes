package webstore.service;

import webstore.domain.Customer;

import java.util.List;

/**
 * @author Sergey Zhernovoy
 * create on 16.09.2017.
 */
public interface CustomerService {
    List<Customer> getAllCustomers();

    void addCustomer(Customer customer);
}
