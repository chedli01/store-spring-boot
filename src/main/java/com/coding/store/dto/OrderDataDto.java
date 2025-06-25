package com.coding.store.dto;

import com.coding.store.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class OrderDataDto {
    private String customer;
    private List<ProductDataDto> products;

}
