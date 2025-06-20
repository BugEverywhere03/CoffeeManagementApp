package com.bugeverywhere.app.model.service;

import com.bugeverywhere.app.model.entity.Product;
import com.bugeverywhere.app.model.repository.IProduct;
import com.bugeverywhere.app.model.repository.impl.ProductRepositoryImpl;

import java.util.List;

public class Service {
    private static final IProduct productRepository = new ProductRepositoryImpl();

    public static List<Product> getListProducts(){
        return productRepository.getAllProducts();
    }
    public static List<Product> getListProductsByCategoryId(int categoryId){
        return productRepository.getProductByCategoryId(categoryId);
    }
}
