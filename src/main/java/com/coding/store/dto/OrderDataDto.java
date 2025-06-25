package com.coding.store.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderDataDto {
    private String customer;
    private double totalPrice;

}
