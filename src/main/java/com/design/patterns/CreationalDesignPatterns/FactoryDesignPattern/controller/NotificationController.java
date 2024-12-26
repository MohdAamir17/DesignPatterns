package com.design.patterns.CreationalDesignPatterns.FactoryDesignPattern.controller;

import com.design.patterns.CreationalDesignPatterns.FactoryDesignPattern.service.Notification;
import com.design.patterns.CreationalDesignPatterns.FactoryDesignPattern.service.NotificationFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @GetMapping("/notify")
    public ResponseEntity<String> notify(@RequestParam String type, @RequestParam String message) {
        try {
            // Create the appropriate Notification object using the factory
            Notification notification = (Notification) NotificationFactory.createNotification(type);
            notification.send(message);
            return ResponseEntity.ok("Notification sent successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
