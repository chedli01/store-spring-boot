package com.coding.store.service;

import com.coding.store.model.Product;
import com.coding.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll(){
        return  this.productRepository.findAll();
    }
}
