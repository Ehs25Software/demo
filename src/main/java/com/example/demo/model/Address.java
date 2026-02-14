package com.example.demo.model;

public class Address {
    private Long id;
    private String customerName;
    private String locality;
    private String landmark;
    private String pincode;
    private String city;
    private String state;
    private String addressType;
    private String mobileNumber;

    public Address() {}

    public Address(Long id, String customerName, String locality, String landmark, 
                   String pincode, String city, String state, String addressType, String mobileNumber) {
        this.id = id;
        this.customerName = customerName;
        this.locality = locality;
        this.landmark = landmark;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.addressType = addressType;
        this.mobileNumber = mobileNumber;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    
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
    
    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
}
