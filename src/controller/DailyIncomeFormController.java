package controller;

import View.tm.DailyTm;
import bo.BoFactory;
import bo.DailyIncomeBo;
import dto.CustomDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import View.UILoader;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DailyIncomeFormController {
    public TableView<DailyTm> tblDaily;
    public TableColumn<Object, Object> colDate;
    public TableColumn<Object, Object> colNumOfOrders;
    public TableColumn<Object, Object> colNumOfItemsSold;
    public TableColumn<Object, Object> colIncome;
    public Button btnBack;
    public Label lblTotal;

    DailyIncomeBo dailyIncomeBo= (DailyIncomeBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.DAILY_INCOME);;

    public void initialize(){
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colNumOfOrders.setCellValueFactory(new PropertyValueFactory<>("NoOfOrders"));
        colNumOfItemsSold.setCellValueFactory(new PropertyValueFactory<>("SoldQuantity"));
        colIncome.setCellValueFactory(new PropertyValueFactory<>("income"));

        try {
            loadData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    ArrayList<DailyTm> dailyTmArrayList=new ArrayList<>();
    ArrayList<DailyTm> arrayList2=new ArrayList<>();

    private void loadData() throws SQLException, ClassNotFoundException {



        ArrayList<CustomDTO> customDTOS = dailyIncomeBo.getdailyItems();
        for (CustomDTO c : customDTOS) {
            dailyTmArrayList.add(new DailyTm(c.getDate(),c.getNoOfOrders(),c.getIncome()));
        }


        loadSecondData();
    }
    int index=0;
    ObservableList<DailyTm> obList= FXCollections.observableArrayList();
    double total;

    private void loadSecondData() throws SQLException, ClassNotFoundException {



        ArrayList<CustomDTO> dailyItemsIncome = dailyIncomeBo.getDailyItemsIncome();
        for (CustomDTO c : dailyItemsIncome) {
            arrayList2.add(new DailyTm(c.getDate(),c.getSoldQuantity()));
        }

        for (DailyTm tm:arrayList2) {
            if (ifExists(tm)==-1){

            }
            index=ifExists(tm);
            DailyTm temp=dailyTmArrayList.get(index);
            DailyTm newTm=new DailyTm(temp.getDate(),temp.getNoOfOrders(),tm.getSoldQuantity(),temp.getIncome());
            dailyTmArrayList.remove(index);
            dailyTmArrayList.add(newTm);
        }

        obList.addAll(dailyTmArrayList);
        tblDaily.setItems(obList);

        for (DailyTm temp:dailyTmArrayList) {
            total+=temp.getIncome();
            lblTotal.setText(String.valueOf(total));
        }



    }

    private int ifExists(DailyTm tm) {
        for (int i = 0; i <dailyTmArrayList.size(); i++) {
            if(tm.getDate().equals(dailyTmArrayList.get(i).getDate())){
                return i;
            }
        }
        return -1;
    }


    public void BackOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/AdminReportForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) btnBack.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(btnBack ,"AdminReportForm");
    }
}
