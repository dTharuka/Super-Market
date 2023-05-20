package controller;

import bo.BoFactory;
import bo.CustomerBo;
import dto.CustomerDTO;
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

public class AddNewCustomerFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtTittle;
    public TextField txtCity;
    public TextField txtProvince;
    public Button btnCancel;
    public TextField txtPostalCode;
    private final LinkedHashMap<TextField, Pattern> patternChecker = new LinkedHashMap<>();
    public Button saveId;

    CustomerBo customerBo= (CustomerBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.CUSTOMER);

    public void initialize(){
        checkTheRegexPattern();
    }

    public void textFeaildChecker(KeyEvent keyEvent){
        ValidationUtil.textFieldChecker(patternChecker,saveId,keyEvent);
    }

    private void checkTheRegexPattern(){
        patternChecker.put(txtId,Pattern.compile("^(C-)[0-9]{2,4}$"));
        patternChecker.put(txtTittle,Pattern.compile("^(mr|mrs)$"));
        patternChecker.put(txtName,Pattern.compile("^[A-z]{3,30}$"));
        patternChecker.put(txtAddress,Pattern.compile("^[A-z]{3,30}$"));
        patternChecker.put(txtCity,Pattern.compile("^[A-z]{4,15}$"));
        patternChecker.put(txtProvince,Pattern.compile("^[A-z]{2,5}$"));
        patternChecker.put(txtPostalCode,Pattern.compile("^[0-9]{5}$"));

    }

    public void SaveCustomerOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {

        CustomerDTO c1=new CustomerDTO(
                txtId.getText(),txtTittle.getText(),txtName.getText(),txtAddress.getText(),
                txtCity.getText(),txtProvince.getText(),txtPostalCode.getText()
        );
        txtId.clear();
        txtName.clear();
        txtTittle.clear();
        txtAddress.clear();
        txtCity.clear();
        txtProvince.clear();
        txtPostalCode.clear();
        if(customerBo.addCustomer(c1))
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
        else
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
    }


    public void CancelOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/CashierForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) btnCancel.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(btnCancel ,"CashierForm");

    }
}
