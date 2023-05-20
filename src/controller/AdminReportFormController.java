package controller;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import View.UILoader;

import java.io.IOException;

public class AdminReportFormController {
    public Button btnItemStatus;
    public Button btnleastMovable;
    public Button btnleastMv;
    public Button btnCwise;
    public Button btnBack;
    public Button btnDailyI;
    public Button btnMonthly;
    public Button btnYearly;

    public void ItemStatusOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/MostMovableItemForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) btnItemStatus.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(btnItemStatus ,"MostMovableItemForm");
    }


    public void leastMvOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/lowestMovableForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) btnleastMv.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(btnleastMv ,"lowestMovableForm");
    }

    public void CustomerWiseIncomeOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/CustomerWiseForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) btnCwise.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(btnCwise ,"CustomerWiseForm");
    }

    public void BackOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/AdminMainForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) btnBack.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(btnBack ,"AdminMainForm");
    }

    public void DailyIncomeOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/DailyIncomeForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) btnDailyI.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(btnDailyI ,"DailyIncomeForm");
    }

    public void MonthlyIncomeOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/MonthlyIncomeForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) btnMonthly.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(btnMonthly ,"MonthlyIncomeForm");
    }

    public void YearlyIncomeOnAction(ActionEvent event) throws IOException {
//        URL resource = getClass().getResource("../View/YeralyIncomeForm.fxml");
//        Parent load = FXMLLoader.load(resource);
//        Stage window = (Stage) btnYearly.getScene().getWindow();
//        window.setScene(new Scene(load));
        UILoader.SetUI(btnYearly ,"YeralyIncomeForm");
    }

    public void playMouseExitedAnimation(MouseEvent mouseEvent) {

        if (mouseEvent.getSource() instanceof Button) {
            Button btn =(Button) mouseEvent.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), btn);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();
            btn.setEffect(null);
        }
    }

    public void playMouseEnterAnimation(MouseEvent mouseEvent) {


        if (mouseEvent.getSource() instanceof Button) {
            Button btn =(Button) mouseEvent.getSource();

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), btn);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.NAVY);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            btn.setEffect(glow);
        }
    }
}
