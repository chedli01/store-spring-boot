package com.coding.store.service;

import com.coding.store.dto.CreateOrderDto;
import com.coding.store.dto.OrderDataDto;
import com.coding.store.dto.ProductDataDto;
import com.coding.store.model.Order;
import com.coding.store.model.Product;
import com.coding.store.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;


    public List<OrderDataDto> getAllOrders(){
        return this.orderRepository.findAll().stream().map(this::mapToDto).toList();
    }

    private OrderDataDto mapToDto(Order order){
        List <ProductDataDto> productDataDtos=order.getProducts().stream().map(product -> new ProductDataDto(product.getName(),product.getPrice())).toList();
        return new OrderDataDto(order.getCustomer(),productDataDtos);
    }
    public OrderDataDto createOrder(CreateOrderDto createOrderDto, Long productId ){
        Order order = new Order();
        order.setCustomer(createOrderDto.getCustomer());
        Product product = productService.findById(productId);
        product.setOrder(order);
        order.getProducts().add(product);


        Order newOrder= this.orderRepository.save(order);
        return mapToDto(newOrder);
    }
    public Order getOrderById(Long orderId){
        return orderRepository.findById(orderId).orElse(null);

    }
    public OrderDataDto placeProduct(Long orderId, Long productId){
        Order order=this.getOrderById(orderId);
        Product product=productService.findById(productId);
        product.setOrder(order);
        order.getProducts().add(product);
        return this.mapToDto(orderRepository.save(order));
    }
}
