package com.design.patterns.BehavioralDesignPatterns.ObserverDesignPattern.Service;

public class EmailObserver implements Observer{
    @Override
    public void update(String event) {
        System.out.println("Email sent for event: " + event);
    }
}
