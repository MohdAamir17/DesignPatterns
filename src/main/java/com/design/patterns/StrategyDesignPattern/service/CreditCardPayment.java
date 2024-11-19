package com.design.patterns.StrategyDesignPattern.service;

import org.springframework.stereotype.Component;

@Component("creditCardPayment")
public class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " with Credit Card");
    }
}
