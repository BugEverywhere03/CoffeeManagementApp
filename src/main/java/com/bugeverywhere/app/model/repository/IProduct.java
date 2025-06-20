package com.bugeverywhere.app.model.repository;

import com.bugeverywhere.app.model.entity.Product;

import java.util.List;

public interface IProduct {
    List<Product> getAllProducts();
    List<Product> getProductByCategoryId(int categoryId);
}
