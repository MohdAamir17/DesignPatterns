package com.design.patterns.BehavioralDesignPatterns.StrategyDesignPattern.service;

public class DebitCardPayment implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " with Debit Card");
    }
}
