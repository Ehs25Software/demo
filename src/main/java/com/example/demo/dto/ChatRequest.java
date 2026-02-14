package com.example.demo.dto;

public class ChatRequest {
    private String mobileno;
    private String message;
    private String messageType;

    public ChatRequest() {}

    // Getters and Setters
    public String getMobileno() { return mobileno; }
    public void setMobileno(String mobileno) { this.mobileno = mobileno; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    
    public String getMessageType() { return messageType; }
    public void setMessageType(String messageType) { this.messageType = messageType; }
}
