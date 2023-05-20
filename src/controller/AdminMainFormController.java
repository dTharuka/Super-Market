package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import View.UILoader;

import java.io.IOException;

public class AdminMainFormController {

    public Button btnManage;
    public Button btnReports;
    public Button btnBack;

    public void MangeItemsOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/AdminItemsForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) btnManage.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(btnManage ,"AdminItemsForm");

    }

    public void ReportsOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/AdminReportForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) btnManage.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(btnManage ,"AdminReportForm");

    }

    public void BackOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/logInForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) btnManage.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(btnManage ,"logInForm");
    }
}
