package com.demo.cart_management.feign;

import com.demo.cart_management.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("product-management")
public interface ProductFeignService {

    @GetMapping("/api/product/{id}")
    Product getProductById(@PathVariable("id") Long id);
}
