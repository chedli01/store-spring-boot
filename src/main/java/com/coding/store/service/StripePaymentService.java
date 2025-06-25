package com.coding.store.service;

import org.springframework.stereotype.Service;

@Service("stripePaymentService")
public class StripePaymentService implements PaymentService {

    public  String proceedPayment(double amount){
        return "yeah  " + amount;
    }
}
