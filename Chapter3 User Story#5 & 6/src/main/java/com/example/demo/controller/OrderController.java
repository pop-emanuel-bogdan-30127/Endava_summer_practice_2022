package com.example.demo.controller;

import com.example.demo.model.Card;
import com.example.demo.model.Order;
import com.example.demo.service.CardService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RequestMapping("api/v1/orders")
@RestController
public class OrderController {

    private final OrderService orderService;
    private final CardService cardService;

    @Autowired
    public OrderController(OrderService orderService, CardService cardService) {
        this.orderService = orderService;
        this.cardService = cardService;
    }

    @PostMapping(path = "/pay")
    public void addOrder(@NonNull @RequestBody Order order) throws Exception {
        cardService.setCard(order.getCard());
        if(cardService.setCard(order.getCard()))
        orderService.add(order);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping(path = "{id}")
    public Order getOrderById(@PathVariable("id") int id){
        return orderService.getOrderById(id);
    }

//    @PostMapping(path = "/pay")
//    public void add(@RequestBody Card card) throws Exception {
//        cardService.setCard(card);
//    }
}
