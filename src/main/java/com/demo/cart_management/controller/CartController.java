package com.demo.cart_management.controller;

import com.demo.cart_management.dto.CartDetailRequestDto;
import com.demo.cart_management.dto.Product;
import com.demo.cart_management.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody CartDetailRequestDto request) {
        cartService.updateCart(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCartByUserId(@PathVariable(name = "id") Long userId) {
        List<Product> result = cartService.getCartByUserId(userId);
        return new ResponseEntity<>(cartService.getCartByUserId(userId), result != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
