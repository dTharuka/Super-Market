package controller;

import bo.BoFactory;
import bo.NewItemBo;
import entity.Item;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import View.UILoader;
import javafx.scene.input.KeyEvent;
import util.ValidationUtil;


import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class NewItemFormController {
    public TextField txtItemCode;
    public TextField txtPackSize;
    public TextField txtUnitPrice;
    public TextField txtQuantityOnHand;
    public Button btnAddItem;
    public Button btnCancel;
    public TextField txtDescription;
    public TextField txtDiscount;
    private final LinkedHashMap<TextField, Pattern> patternChecker = new LinkedHashMap<>();

    NewItemBo newItemBo= (NewItemBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.NEW_ITEM);


    public void initialize(){
        checkTheRegexPattern();
    }

    public void itemTextFeaildChecker(KeyEvent keyEvent){
        ValidationUtil.textFieldChecker(patternChecker,btnAddItem,keyEvent);
    }

    private void checkTheRegexPattern(){
        patternChecker.put(txtItemCode,Pattern.compile("^I-(0)[0-9]{2,5}$"));
        patternChecker.put(txtDescription,Pattern.compile("^[A-z]{2,10}$"));
        patternChecker.put(txtPackSize,Pattern.compile("^(small|medium|large)(/)(small|large|medium)$"));
        patternChecker.put(txtUnitPrice,Pattern.compile("^([0-9]{2}.[0-9]{1,2})$"));
        patternChecker.put(txtQuantityOnHand,Pattern.compile("^[0-9]{1,5}$"));
        patternChecker.put(txtDiscount,Pattern.compile("^[0-9]{1}$"));

    }

    public void AddNewItemOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String discount=null;

        if(txtDiscount.getText().isEmpty()){
            discount="0";
        }else{
            discount=txtDiscount.getText();
        }
        Item i=new Item(
                txtItemCode.getText(),txtDescription.getText(),txtPackSize.getText(),
                Double.parseDouble(txtUnitPrice.getText()),Integer.parseInt(txtQuantityOnHand.getText()),
                Double.parseDouble(discount)
        );

        if(newItemBo.SaveItems(i))
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
        else
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
        txtItemCode.clear();
        txtDescription.clear();
        txtPackSize.clear();
        txtUnitPrice.clear();
        txtQuantityOnHand.clear();
        txtDiscount.clear();

    }

    public void BackOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/AdminItemsForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) btnCancel.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(btnCancel ,"AdminItemsForm");
    }
}
