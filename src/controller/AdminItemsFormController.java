package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import View.UILoader;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import util.ValidationUtil;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class AdminItemsFormController {


    public Button btnNewItem;
    public Button btnModify;
    public Button btnRemoveItems;
    public Button btnBack;

    public void newItemOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/NewItemForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) btnBack.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(btnBack ,"NewItemForm");
    }

    public void ModifyItemOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/ModifyItemForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) btnModify.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(btnModify ,"ModifyItemForm");

    }

    public void removeItemsOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/RemoveItems.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) btnRemoveItems.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(btnRemoveItems ,"RemoveItems");
    }

    public void BackOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/AdminMainForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) btnBack.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(btnBack ,"AdminMainForm");
    }


}
