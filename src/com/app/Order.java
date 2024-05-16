package com.app;

public class Order {
    private int orderId;
    private int petId;
    private int quantity;
    private OrderStatus status;

    public Order(int orderId, int petId, int quantity, OrderStatus status) {
        this.orderId = orderId;
        this.petId = petId;
        this.quantity = quantity;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", petId=" + petId +
                ", quantity=" + quantity +
                ", status=" + status +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
