package com.coding.store;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final PaymentService paymentService;

    public OrderService(StripePaymentService paymentService){
        this.paymentService=paymentService;
    }

    public String placeOrder(){
        return this.paymentService.proceedPayment(20);
    }
}
