package org.example.order;

import org.example.customer.Customer;
import org.example.product.Product;

import java.util.Date;

public class OrderDto {

    private int id;
    private int customerId;
    private int productId;
    private int amount;
    private Date orderDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return null;
    }

    public void setCustomer(Customer customer) {
        this.customerId = 0;
    }

    public Product getProduct() {
        return null;
    }

    public void setProduct(Product product) {
        this.productId = 0;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
