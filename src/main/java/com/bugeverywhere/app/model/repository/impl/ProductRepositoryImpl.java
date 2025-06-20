package com.bugeverywhere.app.model.repository.impl;

import com.bugeverywhere.app.model.entity.Product;
import com.bugeverywhere.app.model.repository.IProduct;
import com.bugeverywhere.app.utils.DatabaseConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProduct {
    private static final Connection connection = DatabaseConnection.getInstance().getConnection();
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT pk_id, ten_do_uong, gia, img_url FROM do_uong";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductID(resultSet.getInt("pk_id"));
                product.setProductName(resultSet.getString("ten_do_uong"));
                product.setProductPrice(resultSet.getDouble("gia"));
                product.setImgUrl(resultSet.getString("img_url"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> getProductByCategoryId(int categoryId) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT pk_id, ten_do_uong, gia, img_url FROM do_uong WHERE fk_ma_loai = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, categoryId);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductID(resultSet.getInt("pk_id"));
                product.setProductName(resultSet.getString("ten_do_uong"));
                product.setProductPrice(resultSet.getDouble("gia"));
                product.setImgUrl(resultSet.getString("img_url"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

}
