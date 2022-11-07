package com.demo.cart_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartDetailRequestDto {
    private long userid;
    private List<ProductRequestDto> productRequestList;

}
