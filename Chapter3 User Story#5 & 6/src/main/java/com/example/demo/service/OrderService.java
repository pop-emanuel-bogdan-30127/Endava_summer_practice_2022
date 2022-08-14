package com.example.demo.service;

import com.example.demo.model.Card;
import com.example.demo.model.Order;
import com.example.demo.repository.CardRepository;
import com.example.demo.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class OrderService {

    private final OrdersRepository ordersRepository;
    private final CardRepository cardRepository;

    @Autowired
    public OrderService(OrdersRepository ordersRepository, CardRepository cardRepository){
        this.ordersRepository = ordersRepository;
        this.cardRepository = cardRepository;
    }
    public void add(Order order) throws IOException {
        ordersRepository.add(order);
    }

    public List<Order> getAllOrders(){
        return ordersRepository.getAll();
    }
    public Order getOrderById(int id){
        return ordersRepository.getOrderById(id);
    }

    public void setCard(Card card) throws Exception {
        cardRepository.setCard(card);
    }
}
