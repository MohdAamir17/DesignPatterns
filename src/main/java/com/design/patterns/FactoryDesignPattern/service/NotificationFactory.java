package com.design.patterns.FactoryDesignPattern.service;



public class NotificationFactory {
    public static Notification createNotification(String type) {
        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotification(); // EmailNotification implements Notification
            case "sms":
                return new SMSNotification(); // SMSNotification implements Notification
            case "push":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Invalid notification type: " + type);
        }
    }
}
