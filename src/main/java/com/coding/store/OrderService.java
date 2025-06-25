package com.coding.store;

import com.coding.store.model.Order;
import com.coding.store.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;


    public List<Order> getAllOrders(){
        return this.orderRepository.findAll();
    }
}
