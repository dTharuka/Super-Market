package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import View.UILoader;

import java.io.IOException;

public class LogInFormController {
    public TextField txtUsername;
    public TextField txtPassword;
    public Button btnLogin;


    public void loginButtonAction(ActionEvent event) throws IOException {
        if(txtUsername.getText().equalsIgnoreCase("admin") && txtPassword.getText().equalsIgnoreCase("1234")) {
//            URL resource = getClass().getResource("../View/AdminMainForm.fxml");
//            Parent load = FXMLLoader.load(resource);
//            Stage window = (Stage) btnLogin.getScene().getWindow();
//            window.setScene(new Scene(load));
            UILoader.SetUI(btnLogin ,"AdminMainForm");
        }else if(txtUsername.getText().equalsIgnoreCase("user") && txtPassword.getText().equalsIgnoreCase("1234")){
//            URL resource = getClass().getResource("../View/CashierForm.fxml");
//            Parent load = FXMLLoader.load(resource);
//            Stage window = (Stage) btnLogin.getScene().getWindow();
//            window.setScene(new Scene(load));
            UILoader.SetUI(btnLogin ,"CashierForm");
        }else{
            new Alert(Alert.AlertType.ERROR,"Incorrect Username Or Password.Try Again").show();
        }
    }

    public void changeOnAction(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }
}
