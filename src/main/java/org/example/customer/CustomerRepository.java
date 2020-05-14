package org.example.customer;

import org.example.util.ResourceReader;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    private static final String RESOURCE_PATH = "sql/customer/";
    private static final String GET_CUSTOMER_BY_ID = getSql("get_customer_by_id.sql");
    private static final String GET_ALL_CUSTOMERS = getSql("get_all_customers.sql");

    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<Customer> rowMapper;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        rowMapper = new BeanPropertyRowMapper<>(Customer.class);
    }

    public Customer getCustomerById(int id) {
        return jdbcTemplate.queryForObject(GET_CUSTOMER_BY_ID, new Object[]{id}, rowMapper);
    }

    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query(GET_ALL_CUSTOMERS, rowMapper);
    }

    private static String getSql(String fileName) {
        return ResourceReader.getSql(RESOURCE_PATH + fileName);
    }
}
