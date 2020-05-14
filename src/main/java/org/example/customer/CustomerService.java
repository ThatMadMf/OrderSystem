package org.example.customer;

import org.example.util.SubmitFailedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    public void addNewCustomer(Customer customer) {
        try {
            customerRepository.addNewCustomer(customer);

        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            throw new SubmitFailedException("Invalid data in new customer form");
        }
    }
}
