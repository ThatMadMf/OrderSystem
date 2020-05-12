package org.example.order;

import org.example.customer.Customer;
import org.example.product.Product;

import java.time.LocalDate;

public class Order {

    private int id;
    private Customer customer;
    private Product product;
    private int amount;
    private LocalDate date;

    public Order(Customer customer, Product product, int amount, LocalDate date) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
