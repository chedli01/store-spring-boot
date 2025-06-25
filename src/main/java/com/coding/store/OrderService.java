package com.coding.store;

import com.coding.store.dto.OrderDataDto;
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


    public List<OrderDataDto> getAllOrders(){
        return this.orderRepository.findAll().stream().map(this::mapToDto).toList();
    }

    private OrderDataDto mapToDto(Order order){
        return new OrderDataDto(order.getCustomer(),order.getProducts().stream().mapToDouble(product -> product.getPrice()).sum());
    }
}
