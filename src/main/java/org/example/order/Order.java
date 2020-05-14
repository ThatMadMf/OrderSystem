package org.example.order;

import org.example.customer.Customer;
import org.example.product.Product;

import java.util.Date;

public class Order {

    private int id;
    private Customer customer;
    private Product product;
    private Delivery delivery;
    private int amount;
    private Date date;
    private double amountPayable;

    public Order(int id, Customer customer, Product product, Delivery delivery, int amount, Date date) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.delivery = delivery;
        this.amount = amount;
        this.date = date;
        amountPayable = product.getPrice() * amount + (delivery == null ? 0 : delivery.getPrice());
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

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public int getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(double amountPayable) {
        this.amountPayable = amountPayable;
    }
}
