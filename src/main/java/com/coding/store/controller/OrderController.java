package com.coding.store.controller;

import com.coding.store.OrderService;
import com.coding.store.PaymentService;
import com.coding.store.dto.OrderDataDto;
import com.coding.store.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")

public class OrderController {
    private  final OrderService orderService;
    @Qualifier("stripePaymentService")
    private  final PaymentService paymentService;

    @GetMapping
    public List<OrderDataDto> getAllOrders(){
        return this.orderService.getAllOrders();
    }
    @GetMapping("/payment")
    public String proceedPayment(@RequestParam(required = false) Double amount){
        if (amount!=null){
        return this.paymentService.proceedPayment(amount);}
        else {
            return "amount is null";
        }

    }



}
