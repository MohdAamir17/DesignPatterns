package com.design.patterns.BehavioralDesignPatterns.StrategyDesignPattern.service;

public class UpiPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via UPI");
    }
}
