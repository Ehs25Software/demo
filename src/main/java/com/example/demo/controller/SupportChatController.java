package com.example.demo.controller;

import com.example.demo.dto.ChatRequest;
import com.example.demo.model.Chat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/mobile/support")
public class SupportChatController {

    private static Long chatIdCounter = 4L;
    private static List<Chat> chatStore = new ArrayList<>();

    static {
        Chat chat1 = new Chat(1L, "Hi, I am AAROGYA, you virtual assistant from Aarogya India, a chat service to find the right products and solutions for you.", 
                             "TEXT", "BOT");
        chat1.setCreatedAt(LocalDateTime.of(2026, 2, 11, 17, 47));
        chatStore.add(chat1);
    }

    @GetMapping("/chat/{mobileNo}")
    public Map<String, Object> getChatHistory(@PathVariable String mobileNo) {
        Map<String, Object> response = new HashMap<>();
        response.put("Status", "Success");
        response.put("chats", chatStore);
        return response;
    }

    @PostMapping("/chat")
    public Map<String, Object> sendChatMessage(@RequestBody ChatRequest request) {
        Map<String, Object> response = new HashMap<>();
        
        Chat userChat = new Chat(chatIdCounter++, request.getMessage(), request.getMessageType(), "CUSTOMER");
        chatStore.add(userChat);
        
        String botReplyMessage = getBotReply(request.getMessage());
        Chat botChat = new Chat(chatIdCounter++, botReplyMessage, "TEXT", "BOT");
        chatStore.add(botChat);
        
        Map<String, String> botReply = new HashMap<>();
        botReply.put("message", botReplyMessage);
        
        response.put("Status", "Success");
        response.put("Message", "Message sent successfully");
        response.put("chat", userChat);
        response.put("botReply", botReply);
        return response;
    }

    @PostMapping("/chat/upload")
    public Map<String, Object> uploadChatMedia(@RequestParam("file") MultipartFile file,
                                               @RequestParam("mobileno") String mobileno,
                                               @RequestParam("messageType") String messageType) {
        Map<String, Object> response = new HashMap<>();
        
        String mediaUrl = "https://example.com/media/" + file.getOriginalFilename();
        
        response.put("Status", "Success");
        response.put("Message", "Media uploaded successfully");
        response.put("mediaUrl", mediaUrl);
        return response;
    }

    private String getBotReply(String userMessage) {
        if (userMessage.toLowerCase().contains("product")) {
            return "Excellent! What do you need help with?";
        } else if (userMessage.toLowerCase().contains("order")) {
            return "I can help you with your orders. Please provide your order ID.";
        } else {
            return "Thank you for your message. How can I assist you today?";
        }
    }
}
