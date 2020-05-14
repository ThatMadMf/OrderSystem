package org.example.order;

import java.util.Date;

public class OrderDto {

    private int id;
    private int customerId;
    private int productId;
    private int amount;
    private Integer deliveryId;
    private Date orderDate;

    public OrderDto() {
    }

    public OrderDto(int customerId, int productId, int amount, Date orderDate, Integer deliveryId) {
        this.customerId = customerId;
        this.productId = productId;
        this.amount = amount;
        this.orderDate = orderDate;
        this.deliveryId = deliveryId;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
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
