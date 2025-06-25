package com.coding.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private  final OrderService  orderService;
    public HomeController(OrderService orderService){
        this.orderService=orderService;

    }


}
