package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.TrackingTimeline;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/mobile/orders")
public class OrderController {

    @GetMapping("/{mobileNo}")
    public Map<String, Object> getUserOrders(@PathVariable String mobileNo) {
        Map<String, Object> response = new HashMap<>();
        
        List<Order> orders = Arrays.asList(
            new Order("123911", "DELIVERED", 670.0, "ONLINE", LocalDateTime.of(2023, 12, 24, 10, 0)),
            new Order("123912", "PENDING", 670.0, "ONLINE", LocalDateTime.of(2023, 12, 24, 10, 0))
        );
        
        response.put("Status", "Success");
        response.put("orders", orders);
        return response;
    }

    @GetMapping("/details/{orderId}")
    public Map<String, Object> getOrderDetails(@PathVariable String orderId) {
        Map<String, Object> response = new HashMap<>();
        
        Order order = new Order("123911", "SHIPPED", 670.0, "ONLINE", LocalDateTime.of(2023, 12, 24, 10, 0));
        order.setProductName("Kiran Diabetes Ras Vanilla Flavour Powder, 400 gm");
        order.setProductImage("https://example.com/product.jpg");
        order.setQuantity(1);
        order.setDeliveryAddress("123, Green Valley, Near Temple, Bangalore, Karnataka - 560001");
        order.setEstimatedDelivery(LocalDateTime.of(2026, 2, 12, 0, 0));
        
        response.put("Status", "Success");
        response.put("order", order);
        return response;
    }

    @GetMapping("/track/{orderId}")
    public Map<String, Object> trackOrder(@PathVariable String orderId) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> tracking = new HashMap<>();
        
        List<TrackingTimeline> timeline = Arrays.asList(
            new TrackingTimeline("Order Confirmed", LocalDateTime.of(2026, 2, 9, 10, 36), true),
            new TrackingTimeline("Packed", LocalDateTime.of(2026, 2, 9, 14, 16), true),
            new TrackingTimeline("Shipped", LocalDateTime.of(2026, 2, 10, 11, 23), true),
            new TrackingTimeline("Out for delivery", null, false),
            new TrackingTimeline("Delivered", null, false)
        );
        
        tracking.put("orderId", orderId);
        tracking.put("estimatedArrival", "Thursday, 12, Feb");
        tracking.put("status", "SHIPPED");
        tracking.put("timeline", timeline);
        tracking.put("deliveryAddress", "123, Green Valley, Near Temple, Bangalore, Karnataka - 560001");
        
        response.put("Status", "Success");
        response.put("tracking", tracking);
        return response;
    }

    @PostMapping("/reorder/{orderId}")
    public Map<String, Object> reorder(@PathVariable String orderId) {
        Map<String, Object> response = new HashMap<>();
        response.put("Status", "Success");
        response.put("Message", "Order placed successfully");
        response.put("newOrderId", "123913");
        return response;
    }
}
