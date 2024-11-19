package com.design.patterns.StrategyDesignPattern.service;

public class UpiPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via UPI");
    }
}
