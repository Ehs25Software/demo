package com.example.demo.model;

import java.time.LocalDateTime;

public class TrackingTimeline {
    private String status;
    private LocalDateTime timestamp;
    private Boolean completed;

    public TrackingTimeline() {}

    public TrackingTimeline(String status, LocalDateTime timestamp, Boolean completed) {
        this.status = status;
        this.timestamp = timestamp;
        this.completed = completed;
    }

    // Getters and Setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    
    public Boolean getCompleted() { return completed; }
    public void setCompleted(Boolean completed) { this.completed = completed; }
}
