package com.bugeverywhere.app.viewmodel;

import com.bugeverywhere.app.model.entity.Product;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductItemViewModel {
    private final StringProperty name;
    private final StringProperty price;
    private final StringProperty imageUrl;

    public ProductItemViewModel(Product product) {
        this.name = new SimpleStringProperty(product.getProductName());
        this.price = new SimpleStringProperty(String.format("%.2f VND", product.getProductPrice()));
        this.imageUrl = new SimpleStringProperty(product.getImgUrl());
    }

    public StringProperty nameProperty() { return name; }
    public StringProperty priceProperty() { return price; }
    public StringProperty imageProperty() { return imageUrl;}
}
