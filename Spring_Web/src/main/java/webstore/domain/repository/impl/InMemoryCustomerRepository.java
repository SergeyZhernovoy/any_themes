package webstore.domain.repository.impl;/**
 * @author Sergey Zhernovoy
 * create on 16.09.2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import webstore.domain.Customer;
import webstore.domain.repository.CustomerRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> getAllCustomers() {
        Map<String, Object> params = new HashMap<>();
        List<Customer> result = jdbcTemplate.query("SELECT * FROM customers", params, new ProductMapper());
        return result;
    }

    @Override
    public void addCustomer(Customer customer) {
        final String SQL = "insert into customers (id, name, address, no_orders_made) "
                + "values (:id, :name, :address, :no_orders)";
        Map<String, Object> params = new HashMap<>();
        params.put("id", customer.getCustomerId());
        params.put("name", customer.getName());
        params.put("address", customer.getAddress());
        params.put("no_orders", customer.getNoOrdersMade());
        jdbcTemplate.update(SQL, params);

    }

    private static final class ProductMapper implements RowMapper<Customer> {
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomerId(rs.getString("ID"));
            customer.setName(rs.getString("NAME"));
            customer.setAddress(rs.getString("ADDRESS"));
            customer.setNoOrdersMade(rs.getBoolean("NO_ORDERS_MADE"));
            return customer;
        }
    }

}

    