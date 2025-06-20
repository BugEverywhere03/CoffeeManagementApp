package com.bugeverywhere.app.view;

import com.bugeverywhere.app.viewmodel.OrderViewModel;
import com.bugeverywhere.app.viewmodel.ProductItemViewModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static java.lang.Long.MAX_VALUE;

public class OrderController implements Initializable {

    @FXML
    private VBox gridOrderView;
    @FXML
    private Label lblTableNumber;
    private OrderViewModel orderViewModel;
    private static final int COLUMNS_PER_ROW = 5;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderViewModel = new OrderViewModel();
    }

    public void setUpForViewModel(int categoryId) {
        orderViewModel.setCategoryId(categoryId);
        orderViewModel.loadProducts();
        Platform.runLater(this::refreshProductGrid);
    }

    private void refreshProductGrid() {
        gridOrderView.getChildren().clear();
        gridOrderView.setFillWidth(true);
        gridOrderView.setPrefWidth(Double.MAX_VALUE);
        List<ProductItemViewModel> products = orderViewModel.getListProducts();
        int totalRows = (int) Math.ceil((double) products.size() / COLUMNS_PER_ROW);

        for (int row = 0; row < totalRows; row++) {
            HBox rowBox = new HBox(10);
            rowBox.setPrefWidth(MAX_VALUE);
            rowBox.setAlignment(Pos.CENTER_LEFT);
            rowBox.setMaxHeight(Double.MAX_VALUE);
            rowBox.setMaxWidth(Double.MAX_VALUE);
            for (int col = 0; col < COLUMNS_PER_ROW; col++) {
                int index = row * COLUMNS_PER_ROW + col;

                if (index < products.size()) {
                    VBox productCard = createProductCard(products.get(index));
                    rowBox.getChildren().add(productCard);
                } else {
                    VBox placeholder = new VBox(10);
                    placeholder.setPrefWidth(220);
                    placeholder.setPrefHeight(150);
                    placeholder.setFillWidth(true);
                    placeholder.setStyle("-fx-padding: 10; -fx-alignment: center; -fx-background-color: white; -fx-border-color: #ffffff; -fx-border-width: 1;");
                    rowBox.getChildren().add(placeholder);
                }
            }

            gridOrderView.getChildren().add(rowBox);
        }
    }

    private VBox createProductCard(ProductItemViewModel productVM) {
        VBox card = new VBox(10);
        card.setStyle("-fx-border-color: #ddd; -fx-border-width: 1; -fx-padding: 10; -fx-alignment: center; -fx-background-color: white;");
        card.setPrefWidth(220);
        card.setPrefHeight(150);
        card.setFillWidth(true);
        ImageView imageView = new ImageView();

        Image image = new Image(Objects.requireNonNull(OrderController.class.getResourceAsStream("/com/bugeverywhere/app/images/" + productVM.imageProperty().get())));
        imageView.setImage(image);
        imageView.setFitWidth(80);
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(true);
        imageView.setStyle("-fx-background-radius: 5;");
        VBox.setVgrow(imageView, Priority.NEVER);
        Label nameLabel = new Label();
        nameLabel.textProperty().bind(productVM.nameProperty());
        nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 12px; -fx-text-alignment: center;");
        nameLabel.setWrapText(true);
        nameLabel.setMaxWidth(Double.MAX_VALUE);
        nameLabel.setAlignment(Pos.CENTER);
        VBox.setVgrow(nameLabel, Priority.SOMETIMES);

        Label priceLabel = new Label();
        priceLabel.textProperty().bind(productVM.priceProperty());
        priceLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-size: 11px; -fx-font-weight: bold; -fx-text-alignment: center;");
        priceLabel.setMaxWidth(Double.MAX_VALUE);
        priceLabel.setAlignment(Pos.CENTER);
        VBox.setVgrow(priceLabel, Priority.NEVER);

        card.getChildren().addAll(imageView, nameLabel, priceLabel);

        return card;
    }
}
