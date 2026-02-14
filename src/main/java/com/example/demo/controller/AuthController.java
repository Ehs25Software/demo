package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OtpRequest;
import com.example.demo.model.Customer;
import com.example.demo.util.JwtUtil;

@RestController
@RequestMapping("/api/mobile/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    // In-memory storage for OTPs (mobile number -> OTP)
    private static final Map<String, String> otpStorage = new ConcurrentHashMap<>();

    @PostMapping("/request-otp")
    public Map<String, Object> requestOtp(@RequestBody OtpRequest request) {
        Map<String, Object> response = new HashMap<>();
        
        // Store OTP for this mobile number
        otpStorage.put(request.getMobileno(), request.getOtp());
        
        response.put("Status", "Success");
        response.put("Message", "OTP sent successfully");
        response.put("otp", request.getOtp());
        response.put("mobileNumber", request.getMobileno());
        return response;
    }

    @PostMapping("/verify-otp")
    public Map<String, Object> verifyOtp(@RequestBody OtpRequest request) {
        Map<String, Object> response = new HashMap<>();
        
        // Get stored OTP for this mobile number
        String storedOtp = otpStorage.get(request.getMobileno());
        
        if (storedOtp != null && storedOtp.equals(request.getOtp())) {
            Customer customer = new Customer(1L, "Arjun Sharma", request.getMobileno(), 
                                            "awesome.123@yopmail.com", "MALE");
            
            // Generate JWT token
            String token = jwtUtil.generateToken(request.getMobileno(), customer.getId());
            
            // Remove OTP after successful verification
            otpStorage.remove(request.getMobileno());
            
            response.put("Status", "Success");
            response.put("Message", "Login successful");
            response.put("token", token);
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
        
        // Store new OTP for this mobile number
        otpStorage.put(request.getMobileno(), request.getOtp());
        
        response.put("Status", "Success");
        response.put("Message", "OTP resent successfully");
        response.put("otp", request.getOtp());
        response.put("mobileNumber", request.getMobileno());
        return response;
    }

    @PostMapping("/validate-token")
    public Map<String, Object> validateToken(@RequestHeader("Authorization") String authHeader) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            String token = authHeader.replace("Bearer ", "");
            
            if (jwtUtil.validateToken(token)) {
                String mobileNumber = jwtUtil.extractMobileNumber(token);
                Long customerId = jwtUtil.extractCustomerId(token);
                
                response.put("Status", "Success");
                response.put("Message", "Token is valid");
                response.put("mobileNumber", mobileNumber);
                response.put("customerId", customerId);
            } else {
                response.put("Status", "Failed");
                response.put("Message", "Invalid or expired token");
            }
        } catch (Exception e) {
            response.put("Status", "Failed");
            response.put("Message", "Invalid token format");
        }
        
        return response;
    }
}
