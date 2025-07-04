package com.coding.store.controller;

import com.coding.store.dto.CreateOrderDto;
import com.coding.store.model.User;
import com.coding.store.service.OrderService;
import com.coding.store.service.PaymentService;
import com.coding.store.dto.OrderDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public List<OrderDataDto> getAllOrders(@AuthenticationPrincipal User user){

        System.out.println("Request made by: " + user.getId());



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
    @PostMapping("/product/{id}")
    public OrderDataDto createOrder(@RequestBody CreateOrderDto createOrderDto, @PathVariable Long id){
        return this.orderService.createOrder(createOrderDto,id);
    }
    @PostMapping("{orderId}/product/{productId}/place")
    public OrderDataDto placeProduct(@PathVariable Long orderId, @PathVariable Long productId){
        return  this.orderService.placeProduct(orderId,productId);
    }



}
