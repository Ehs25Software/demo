package com.example.demo.controller;

import com.example.demo.dto.OtpRequest;
import com.example.demo.model.Customer;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/mobile/auth")
public class AuthController {

    @PostMapping("/request-otp")
    public Map<String, Object> requestOtp(@RequestBody OtpRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("Status", "Success");
        response.put("Message", "OTP sent successfully");
        response.put("otp", request.getOtp());
        response.put("mobileNumber", request.getMobileno());
        return response;
    }

    @PostMapping("/verify-otp")
    public Map<String, Object> verifyOtp(@RequestBody OtpRequest request) {
        Map<String, Object> response = new HashMap<>();
        
        if ("123456".equals(request.getOtp())) {
            Customer customer = new Customer(1L, "Arjun Sharma", request.getMobileno(), 
                                            "awesome.123@yopmail.com", "MALE");
            
            response.put("Status", "Success");
            response.put("Message", "Login successful");
            response.put("customer", customer);
        } else {
            response.put("Status", "Failed");
            response.put("Message", "Invalid OTP");
        }
        
        return response;
    }

    @PostMapping("/resend-otp")
    public Map<String, Object> resendOtp(@RequestBody OtpRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("Status", "Success");
        response.put("Message", "OTP resent successfully");
        response.put("otp", request.getOtp());
        response.put("mobileNumber", request.getMobileno());
        return response;
    }
}
