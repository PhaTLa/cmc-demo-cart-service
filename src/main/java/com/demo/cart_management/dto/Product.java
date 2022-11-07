package com.demo.cart_management.dto;

import com.demo.cart_management.common.BaseVo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product extends BaseVo {
    private Long id;

    private String name;

    private Double price;

    private String desc;

    @JsonProperty("images")
    private List<Image> listImg;

    @JsonProperty("categories")
    private List<Category> listCategory;

    private Integer quantity;

    public Product(String name, Double price, String desc) {
        this.name = name;
        this.price = price;
        this.desc = desc;

    }
}