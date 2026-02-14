package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public Map<String, Object> welcome() {
        Map<String, Object> response = new HashMap<>();
        response.put("application", "Aarogya India Phone App API");
        response.put("version", "1.0.0");
        response.put("status", "Running");
        response.put("message", "Welcome to Aarogya India API");
        response.put("documentation", "/api-docs");
        
        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("Authentication", "/api/mobile/auth/*");
        endpoints.put("Profile", "/api/mobile/profile/*");
        endpoints.put("Addresses", "/api/mobile/addresses/*");
        endpoints.put("Orders", "/api/mobile/orders/*");
        endpoints.put("Reviews", "/api/mobile/reviews/*");
        endpoints.put("Support Chat", "/api/mobile/support/chat/*");
        endpoints.put("Dashboard", "/api/mobile/dashboard/*");
        
        response.put("endpoints", endpoints);
        return response;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("message", "API is healthy");
        return response;
    }
}
