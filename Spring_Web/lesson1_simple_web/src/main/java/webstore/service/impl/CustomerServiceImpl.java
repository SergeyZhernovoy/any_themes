package webstore.service.impl;/**
 * @author Sergey Zhernovoy
 * create on 16.09.2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webstore.domain.Customer;
import webstore.domain.repository.CustomerRepository;
import webstore.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.getAllCustomers();
    }
}

    