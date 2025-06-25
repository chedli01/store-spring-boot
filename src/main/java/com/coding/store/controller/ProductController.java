package com.coding.store.controller;

import com.coding.store.dto.ProductDataDto;
import com.coding.store.model.Product;
import com.coding.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDataDto> getAll(){
        return  this.productService.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductDataDto productDataDto){
        return  this.productService.createProduct(productDataDto);

    }

}
