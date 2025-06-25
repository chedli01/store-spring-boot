package com.coding.store.service;

import com.coding.store.dto.ProductDataDto;
import com.coding.store.model.Product;
import com.coding.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductDataDto> findAll(){
        return  this.productRepository.findAll().stream().map(this::mapToDto).toList();
    }

    private ProductDataDto mapToDto(Product product){
        return new ProductDataDto(product.getName(),product.getPrice());
    }
}
