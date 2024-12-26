package com.design.patterns.BehavioralDesignPatterns.StrategyDesignPattern.service;

import org.springframework.stereotype.Component;

@Component("payPalPayment")
public class PayPalPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via PayPal");
    }
}
