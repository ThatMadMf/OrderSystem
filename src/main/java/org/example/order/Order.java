package org.example.order;

import org.example.customer.Customer;
import org.example.product.Product;

import java.util.Date;

public class Order {

    private int id;
    private Customer customer;
    private Product product;
    private int amount;
    private Date date;

    public Order(int id, Customer customer, Product product, int amount, Date date) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}
