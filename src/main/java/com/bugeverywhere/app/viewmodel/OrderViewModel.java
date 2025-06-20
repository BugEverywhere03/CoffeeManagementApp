package com.bugeverywhere.app.viewmodel;

import com.bugeverywhere.app.model.entity.Product;
import com.bugeverywhere.app.model.service.Service;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;
import java.util.List;



public class OrderViewModel {
    @Getter
    private ObservableList<ProductItemViewModel> listProducts = FXCollections.observableArrayList();
    @Setter
    private final IntegerProperty tableId = new SimpleIntegerProperty();
    @Setter
    private int categoryId;

    public void loadProducts() {
       List<Product> products = Service.getListProducts();
       if (categoryId > 0) {
        products = Service.getListProductsByCategoryId(categoryId);
       }

        if (products != null) {
            for (Product product : products) {
                listProducts.add(new ProductItemViewModel(product));
            }
        }
    }
}