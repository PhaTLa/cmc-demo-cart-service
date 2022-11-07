/**
 * @mbg.generated generator on Fri Aug 26 13:33:47 GMT+07:00 2022
 */
package com.demo.cart_management.service.impl;

import com.demo.cart_management.dao.CartMapper;
import com.demo.cart_management.dto.*;
import com.demo.cart_management.feign.ProductFeignService;
import com.demo.cart_management.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;

    @Autowired
    ProductFeignService productFeignService;

    @Override
    public void updateCart(CartDetailRequestDto request) {
        // check exists cart
        Long cartId = null;
        Cart cart = cartMapper.getCartByUserId(request.getUserid());
        if (cart == null) {
            Cart newCart = new Cart();
            newCart.setUserId(request.getUserid());
            cartId = cartMapper.insertCart(newCart);
        }else {
            cartId = cart.getId();
        }
        cartMapper.deleteCartByCartId(cartId);
        for (ProductRequestDto item : request.getProductRequestList()){
            CartDetail cartDetail = new CartDetail();
            cartDetail.setCartId(cartId);
            cartDetail.setProductId(item.getId());
            cartDetail.setQuantity(item.getCount());
            cartMapper.insertCartDetail(cartDetail);
        }
    }

    @Override
    public List<Product> getCartByUserId(Long userId) {
        Cart userCart = cartMapper.getCartByUserId(userId);
        List<CartDetail> cartDetails = cartMapper.getCartDetailByCartId(userCart.getId());
        List<Product> productList = new ArrayList<>();

        cartDetails.forEach(cartDetail -> {
            Product product = productFeignService.getProductById(cartDetail.getProductId());
            productList.add(product);
        });

        return productList;
    }
}