package com.tonny.orderservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tonny.orderservice.dto.OrderRequest;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @PostMapping
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        return "Order placed successfully";
    }
    
}
