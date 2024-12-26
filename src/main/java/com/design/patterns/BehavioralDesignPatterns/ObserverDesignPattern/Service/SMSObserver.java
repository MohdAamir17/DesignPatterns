package com.design.patterns.BehavioralDesignPatterns.ObserverDesignPattern.Service;

public class SMSObserver implements Observer{
    @Override
    public void update(String event) {
        System.out.println("SMS sent for event: " + event);
    }
}
