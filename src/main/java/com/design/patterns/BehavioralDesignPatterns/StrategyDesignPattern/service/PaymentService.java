package com.design.patterns.BehavioralDesignPatterns.StrategyDesignPattern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentStrategy paymentStrategy;

    @Autowired
    public PaymentService(@Qualifier("creditCardPayment") PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.pay(amount);
    }
}




/*
Example: You can use @Profile to automatically inject different strategies based on the active profile:
 */

/*
@Component
@Profile("dev")
public class DevPaymentStrategy implements PaymentStrategy { /* ... */


/*
@Component
@Profile("prod")
public class ProdPaymentStrategy implements PaymentStrategy { /* ... */
