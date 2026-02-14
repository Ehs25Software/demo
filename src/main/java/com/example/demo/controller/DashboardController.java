package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/mobile/dashboard")
public class DashboardController {

    @GetMapping("/{mobileNo}")
    public Map<String, Object> getDashboard(@PathVariable String mobileNo) {
        Map<String, Object> response = new HashMap<>();
        
        Customer customer = new Customer(1L, "Arjun Sharma", mobileNo, 
                                        "awesome.123@yopmail.com", "MALE");
        
        Order recentOrder = new Order("123911", "SHIPPED", 670.0, "ONLINE", 
                                     LocalDateTime.of(2023, 10, 24, 0, 0));
        
        Address primaryAddress = new Address(1L, "Rahul Sharma", "123, Green Valley, Near Temple", 
                                            "Temple", "560001", "Bangalore", "Karnataka", 
                                            "HOME", "+91 98765 43210");
        
        response.put("Status", "Success");
        response.put("customer", customer);
        response.put("recentOrder", recentOrder);
        response.put("primaryAddress", primaryAddress);
        return response;
    }
}
