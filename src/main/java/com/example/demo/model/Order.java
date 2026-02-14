package com.example.demo.model;

import java.time.LocalDateTime;

public class Order {
    private String orderId;
    private String status;
    private Double totalAmount;
    private String paymentMode;
    private LocalDateTime placedOn;
    private String productName;
    private String productImage;
    private Integer quantity;
    private String deliveryAddress;
    private LocalDateTime estimatedDelivery;

    public Order() {}

    public Order(String orderId, String status, Double totalAmount, String paymentMode, LocalDateTime placedOn) {
        this.orderId = orderId;
        this.status = status;
        this.totalAmount = totalAmount;
        this.paymentMode = paymentMode;
        this.placedOn = placedOn;
    }

    // Getters and Setters
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
    
    public String getPaymentMode() { return paymentMode; }
    public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }
    
    public LocalDateTime getPlacedOn() { return placedOn; }
    public void setPlacedOn(LocalDateTime placedOn) { this.placedOn = placedOn; }
    
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    
    public String getProductImage() { return productImage; }
    public void setProductImage(String productImage) { this.productImage = productImage; }
    
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
    
    public LocalDateTime getEstimatedDelivery() { return estimatedDelivery; }
    public void setEstimatedDelivery(LocalDateTime estimatedDelivery) { this.estimatedDelivery = estimatedDelivery; }
}
