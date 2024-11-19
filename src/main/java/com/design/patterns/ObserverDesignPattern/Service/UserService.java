package com.design.patterns.ObserverDesignPattern.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<Observer> observers = new ArrayList<>();

    // Method to register observers
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    // Method to notify all registered observers of an event
    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    // Method to register a new user and notify observers
    public void registerUser(String username) {
        System.out.println("User registered: " + username);
        notifyObservers("User Registration");
    }
}
