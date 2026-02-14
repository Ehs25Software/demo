package com.example.demo.model;

import java.time.LocalDateTime;

public class Chat {
    private Long id;
    private String message;
    private String messageType;
    private String senderType;
    private LocalDateTime createdAt;

    public Chat() {}

    public Chat(Long id, String message, String messageType, String senderType) {
        this.id = id;
        this.message = message;
        this.messageType = messageType;
        this.senderType = senderType;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    
    public String getMessageType() { return messageType; }
    public void setMessageType(String messageType) { this.messageType = messageType; }
    
    public String getSenderType() { return senderType; }
    public void setSenderType(String senderType) { this.senderType = senderType; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
