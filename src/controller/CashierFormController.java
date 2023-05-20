package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import View.UILoader;

import java.io.IOException;

public class CashierFormController {
    public Button backBtn;
    public Button btnAddNewCustomer;

    public void addNewCustomerOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/addNewCustomerForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) backBtn.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(backBtn ,"addNewCustomerForm");
    }

    public void manageOrdersOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/CashierMainForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) backBtn.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(backBtn ,"CashierMainForm");
    }

    public void backBtnOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/loginForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) backBtn.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(backBtn ,"loginForm");
    }
}
