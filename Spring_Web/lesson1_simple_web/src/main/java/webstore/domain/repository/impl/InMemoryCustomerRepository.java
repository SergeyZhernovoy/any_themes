package webstore.domain.repository.impl;/**
 * @author Sergey Zhernovoy
 * create on 16.09.2017.
 */

import org.springframework.stereotype.Repository;
import webstore.domain.Customer;
import webstore.domain.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private List<Customer> customers;

    public InMemoryCustomerRepository() {
        this.customers = new ArrayList<>();
        Customer cust1 = new Customer();
        cust1.setAddress("Penza");
        cust1.setCustomerId("A123");
        cust1.setName("Sergey");
        cust1.setNoOrdersMade(true);
        this.customers.add(cust1);

        cust1 = new Customer();
        cust1.setAddress("Kuzneck");
        cust1.setCustomerId("A124");
        cust1.setName("Petr");
        cust1.setNoOrdersMade(true);
        this.customers.add(cust1);

        cust1 = new Customer();
        cust1.setAddress("Brjansk");
        cust1.setCustomerId("A126");
        cust1.setName("Kolja");
        cust1.setNoOrdersMade(true);
        this.customers.add(cust1);

        cust1 = new Customer();
        cust1.setAddress("Moskva");
        cust1.setCustomerId("A127");
        cust1.setName("Olga");
        cust1.setNoOrdersMade(true);
        this.customers.add(cust1);

    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customers;
    }
}

    