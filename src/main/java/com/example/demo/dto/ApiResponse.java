package com.example.demo.dto;

public class ApiResponse {
    private String Status;
    private String Message;
    private Object data;

    public ApiResponse() {}

    public ApiResponse(String status, String message) {
        this.Status = status;
        this.Message = message;
    }

    public ApiResponse(String status, String message, Object data) {
        this.Status = status;
        this.Message = message;
        this.data = data;
    }

    // Getters and Setters
    public String getStatus() { return Status; }
    public void setStatus(String status) { Status = status; }
    
    public String getMessage() { return Message; }
    public void setMessage(String message) { Message = message; }
    
    public Object getData() { return data; }
    public void setData(Object data) { this.data = data; }
}
