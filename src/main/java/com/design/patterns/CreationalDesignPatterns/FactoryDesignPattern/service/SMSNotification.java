package com.design.patterns.CreationalDesignPatterns.FactoryDesignPattern.service;

public class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("SMS sent with message: " + message);
    }
}
