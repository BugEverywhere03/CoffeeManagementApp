package com.bugeverywhere.app.view;

import com.bugeverywhere.app.viewmodel.HomeViewModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;

public class HomeController implements Initializable{
    @FXML
    private TabPane tabPane;
    @FXML
    private GridPane gridHomeView;



    @FXML
    private void onButtonNewOrderClick(){

    }
    @FXML
    private void onButtonHistoryClicked(){

    }
    @FXML
    private void onButtonOrderClicked(){
        tabPane.getSelectionModel().select(0);
    }


    private HomeViewModel homeViewModel;

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        homeViewModel = new HomeViewModel();
    }


    public void onMenuButtonClicked(ActionEvent actionEvent) {
        String categoryName = ((Button) actionEvent.getSource()).getText();
        int categoryId = switch (categoryName) {
            case "Espresso" -> 1;
            case "Socola" -> 2;
            case "Frappuccino Coffee" -> 3;
            case "Frappuccino Icream" -> 4;
            case "Tea" -> 5;
            default -> 0;
        };
        Platform.runLater(() -> {
            showOrderView(categoryId);
        });

    }

    private void showOrderView(int categoryId) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HomeController.class.getResource("/com/bugeverywhere/app/fxml/order.fxml"));
            Parent root = fxmlLoader.load();
            OrderController controller = fxmlLoader.getController();
            controller.setUpForViewModel(categoryId);
            gridHomeView.getChildren().remove(tabPane);
            gridHomeView.add(root, 0,1);
            GridPane.setColumnSpan(root, 2);
            GridPane.setRowSpan(root, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
