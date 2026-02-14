package com.example.demo.model;

import java.time.LocalDateTime;

public class Review {
    private Long id;
    private String customerName;
    private Integer rating;
    private String title;
    private String description;
    private String imageUrl;
    private LocalDateTime createdAt;
    private Long productId;

    public Review() {}

    public Review(Long id, String customerName, Integer rating, String title, 
                  String description, String imageUrl, Long productId) {
        this.id = id;
        this.customerName = customerName;
        this.rating = rating;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.productId = productId;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
}
