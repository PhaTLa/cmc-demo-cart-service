/**
 * @mbg.generated generator on Fri Aug 26 13:33:47 GMT+07:00 2022
 */
package com.demo.cart_management.service;

import com.demo.cart_management.dto.CartDetailRequestDto;
import com.demo.cart_management.dto.Product;

import java.util.List;

public interface CartService {


    void updateCart(CartDetailRequestDto request);

    List<Product> getCartByUserId(Long userId);
}