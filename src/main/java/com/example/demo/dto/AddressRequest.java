package com.example.demo.dto;

public class AddressRequest {
    private String mobileno;
    private String locality;
    private String landmark;
    private String pincode;
    private String city;
    private String state;
    private String addressType;

    public AddressRequest() {}

    // Getters and Setters
    public String getMobileno() { return mobileno; }
    public void setMobileno(String mobileno) { this.mobileno = mobileno; }
    
    public String getLocality() { return locality; }
    public void setLocality(String locality) { this.locality = locality; }
    
    public String getLandmark() { return landmark; }
    public void setLandmark(String landmark) { this.landmark = landmark; }
    
    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }
    
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    
    public String getAddressType() { return addressType; }
    public void setAddressType(String addressType) { this.addressType = addressType; }
}
