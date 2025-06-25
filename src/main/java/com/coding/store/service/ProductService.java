package com.coding.store.service;

import com.coding.store.dto.ProductDataDto;
import com.coding.store.model.Product;
import com.coding.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Product createProduct(ProductDataDto createProductDto ){
        Product product = new Product();
        product.setName(createProductDto.getName());
        product.setPrice(createProductDto.getPrice());
        return this.productRepository.save(product);

    }
}
