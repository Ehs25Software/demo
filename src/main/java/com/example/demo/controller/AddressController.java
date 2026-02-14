package com.example.demo.controller;

import com.example.demo.dto.AddressRequest;
import com.example.demo.model.Address;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/mobile/addresses")
public class AddressController {

    private static Long addressIdCounter = 3L;
    private static Map<Long, Address> addressStore = new HashMap<>();

    static {
        addressStore.put(1L, new Address(1L, "Rahul Sharma", "123, Green Valley, Near Temple", 
                                        "Temple", "560001", "Bangalore", "Karnataka", "HOME", "+91 98765 43210"));
        addressStore.put(2L, new Address(2L, "Rahul Sharma", "E-23, Sec 63 Noida", 
                                        "Temple", "201301", "Noida", "Uttar pradesh", "COMPANY", "+91 98765 43210"));
    }

    @GetMapping("/{mobileNo}")
    public Map<String, Object> getAllAddresses(@PathVariable String mobileNo) {
        Map<String, Object> response = new HashMap<>();
        response.put("Status", "Success");
        response.put("addresses", new ArrayList<>(addressStore.values()));
        return response;
    }

    @PostMapping
    public Map<String, Object> addAddress(@RequestBody AddressRequest request) {
        Map<String, Object> response = new HashMap<>();
        
        Address address = new Address(addressIdCounter++, "Rahul Sharma", request.getLocality(), 
                                     request.getLandmark(), request.getPincode(), request.getCity(), 
                                     request.getState(), request.getAddressType(), "+91 " + request.getMobileno());
        
        addressStore.put(address.getId(), address);
        
        response.put("Status", "Success");
        response.put("Message", "Address added successfully");
        response.put("address", address);
        return response;
    }

    @PutMapping("/{addressId}")
    public Map<String, Object> updateAddress(@PathVariable Long addressId, @RequestBody AddressRequest request) {
        Map<String, Object> response = new HashMap<>();
        
        Address address = addressStore.get(addressId);
        if (address != null) {
            address.setLocality(request.getLocality());
            address.setLandmark(request.getLandmark());
            address.setPincode(request.getPincode());
            address.setCity(request.getCity());
            address.setState(request.getState());
            address.setAddressType(request.getAddressType());
            
            response.put("Status", "Success");
            response.put("Message", "Address updated successfully");
            response.put("address", address);
        } else {
            response.put("Status", "Failed");
            response.put("Message", "Address not found");
        }
        
        return response;
    }

    @DeleteMapping("/{addressId}")
    public Map<String, Object> deleteAddress(@PathVariable Long addressId) {
        Map<String, Object> response = new HashMap<>();
        
        if (addressStore.remove(addressId) != null) {
            response.put("Status", "Success");
            response.put("Message", "Address deleted successfully");
        } else {
            response.put("Status", "Failed");
            response.put("Message", "Address not found");
        }
        
        return response;
    }
}
