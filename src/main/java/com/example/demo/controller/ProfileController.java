package com.example.demo.controller;

import com.example.demo.dto.ProfileUpdateRequest;
import com.example.demo.model.Customer;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/mobile")
public class ProfileController {

    @GetMapping("/profile/{mobileNo}")
    public Map<String, Object> getProfile(@PathVariable String mobileNo) {
        Map<String, Object> response = new HashMap<>();
        
        Customer customer = new Customer(1L, "Arjun Sharma", mobileNo, 
                                        "awesome.123@yopmail.com", "MALE");
        customer.setCreatedAt(LocalDateTime.of(2024, 1, 1, 10, 0));
        customer.setLastLogin(LocalDateTime.of(2026, 2, 11, 19, 2));
        
        response.put("Status", "Success");
        response.put("customer", customer);
        return response;
    }

    @PutMapping("/profile")
    public Map<String, Object> updateProfile(@RequestBody ProfileUpdateRequest request) {
        Map<String, Object> response = new HashMap<>();
        
        Customer customer = new Customer(1L, request.getName(), request.getMobileno(), 
                                        request.getEmail(), request.getGender());
        
        response.put("Status", "Success");
        response.put("Message", "Profile updated successfully");
        response.put("customer", customer);
        return response;
    }
}
