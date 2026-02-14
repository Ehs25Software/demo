package com.example.demo.dto;

import java.util.Random;

public class OtpRequest {
    private String mobileno;
    private String otp;

    public OtpRequest() {
        // Automatically generate a 6-digit random OTP when object is created
        Random random = new Random();
        int number = 100000 + random.nextInt(900000);
        this.otp = String.valueOf(number);
    }

    // Getters and Setters
    public String getMobileno() { return mobileno; }
    public void setMobileno(String mobileno) { this.mobileno = mobileno; }
    
    public String getOtp() { return otp; }
    public void setOtp(String otp) { this.otp = otp; }
}
