package com.bugeverywhere.app.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int productID;
    private String productName;
    private double productPrice;
    private int categoryID;
    private String imgUrl;
}
