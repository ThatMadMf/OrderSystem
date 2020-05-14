package org.example.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());

        return "customer/customers";
    }

    @GetMapping("new-customer")
    public String addNewCustomer(Model model) {
        model.addAttribute("customer", new Customer());

        return "customer/new-customer";
    }

    @PostMapping("new-customer")
    public String processNewCustomer(@ModelAttribute Customer customer, Model model) {

        customerService.addNewCustomer(customer);

        model.addAttribute("success", true);

        return "submission-result";
    }
}
