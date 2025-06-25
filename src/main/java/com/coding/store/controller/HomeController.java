package com.coding.store.controller;

import com.coding.store.service.OrderService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private  final OrderService orderService;
    public HomeController(OrderService orderService){
        this.orderService=orderService;

    }


}
