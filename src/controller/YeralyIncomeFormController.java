package controller;

import View.tm.DailyTm;
import bo.BoFactory;
import bo.YearlyIncomeBo;
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

public class YeralyIncomeFormController {
    public TableView<DailyTm> tblYearly;
    public TableColumn<Object, Object> colYear;
    public TableColumn<Object, Object> colNumOfOrders;
    public TableColumn<Object, Object> colNumOfItemsSold;
    public TableColumn<Object, Object> colIncome;
    public Button btnBack;
    public Label lblTotal;

   YearlyIncomeBo yearlyIncomeBo= (YearlyIncomeBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.YEARLY_INCOME);

    public void initialize(){
        colYear.setCellValueFactory(new PropertyValueFactory<>("date"));
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


        ArrayList<CustomDTO> monthlyIncome = yearlyIncomeBo.getMonthlyIncome();
        for (CustomDTO c : monthlyIncome) {
            dailyTmArrayList.add(new DailyTm(c.getDate(),c.getNoOfOrders(),c.getSoldQuantity(),c.getIncome()));
        }

        loadSecondData();
    }
    int index=0;
    ObservableList<DailyTm> obList= FXCollections.observableArrayList();
    double total;

    private void loadSecondData() throws SQLException, ClassNotFoundException {

        ArrayList<CustomDTO> yearlyOrderIncome = yearlyIncomeBo.getYearlyOrderIncome();
        for (CustomDTO c : yearlyOrderIncome) {
            arrayList2.add(new DailyTm(c.getDate(),c.getNoOfOrders(),c.getSoldQuantity(),c.getIncome()));
        }

        for (DailyTm tm:arrayList2) {
            if (ifExists(tm)==-1){

            }
            index=ifExists(tm);
            DailyTm temp=dailyTmArrayList.get(index);
            DailyTm newTm=new DailyTm(tm.getDate(),temp.getNoOfOrders()+tm.getNoOfOrders(),tm.getSoldQuantity()+tm.getSoldQuantity(),temp.getIncome()+tm.getIncome());
            dailyTmArrayList.remove(index);
            dailyTmArrayList.add(newTm);
        }

        for (DailyTm TM:dailyTmArrayList) {
            if(ifExists2(TM)==-1){
                obList.add(TM);
            }else{
                int num=ifExists2(TM);
                DailyTm TEMP=obList.get(num);
                DailyTm newTm=new DailyTm(TEMP.getDate(),TEMP.getNoOfOrders()+TM.getNoOfOrders(),TEMP.getSoldQuantity()+TM.getSoldQuantity(),TEMP.getIncome()+TM.getIncome());
                obList.remove(num);
                obList.add(newTm);
            }
        }

        tblYearly.setItems(obList);

        for (DailyTm temp:dailyTmArrayList) {
            total+=temp.getIncome();
            lblTotal.setText(String.valueOf(total));
        }



    }

    private int ifExists2(DailyTm tm) {
        for (int i = 0; i <obList.size() ; i++) {
            if(tm.getDate().equals(obList.get(i).getDate())){
                return i;
            }
        }
        return -1;
    }

    private int ifExists(DailyTm tm) {
        for (int i = 0; i <dailyTmArrayList.size(); i++) {
            int tempMonth=Integer.parseInt(dailyTmArrayList.get(i).getDate().split("-")[0]);
            if(tm.getDate().equals(String.valueOf(tempMonth))){
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
