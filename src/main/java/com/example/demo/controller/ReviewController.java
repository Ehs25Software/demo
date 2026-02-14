package com.example.demo.controller;

import com.example.demo.dto.ReviewRequest;
import com.example.demo.model.Review;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/mobile/reviews")
public class ReviewController {

    private static Long reviewIdCounter = 3L;
    private static List<Review> reviewStore = new ArrayList<>();

    static {
        reviewStore.add(new Review(1L, "Rahul Kumar", 5, "Just awesome", 
            "Exploring ways to increase your strength and stamina? Switch to the Ayurvedic goodness of Arigya India Shilajit.",
            "https://example.com/review1.jpg", 1L));
        reviewStore.add(new Review(2L, "Priya Singh", 4, "Good product", 
            "Very effective product. Noticed improvement in energy levels.",
            "https://example.com/review2.jpg", 1L));
    }

    @GetMapping("/product/{productId}")
    public Map<String, Object> getProductReviews(@PathVariable Long productId) {
        Map<String, Object> response = new HashMap<>();
        
        List<Review> productReviews = new ArrayList<>();
        for (Review review : reviewStore) {
            if (review.getProductId().equals(productId)) {
                productReviews.add(review);
            }
        }
        
        response.put("Status", "Success");
        response.put("averageRating", 4.7);
        response.put("totalReviews", productReviews.size());
        response.put("reviews", productReviews);
        return response;
    }

    @PostMapping
    public Map<String, Object> submitReview(@RequestBody ReviewRequest request) {
        Map<String, Object> response = new HashMap<>();
        
        Review review = new Review(reviewIdCounter++, "Customer", request.getRating(), 
                                  request.getTitle(), request.getDescription(), 
                                  request.getImageUrl(), request.getProductId());
        
        reviewStore.add(review);
        
        response.put("Status", "Success");
        response.put("Message", "Review submitted successfully");
        response.put("review", review);
        return response;
    }
}
