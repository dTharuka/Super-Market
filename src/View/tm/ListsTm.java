package View.tm;

import javafx.scene.control.Button;
//===============Add to Cart Table=======================
public class ListsTm {
    private String ItemCode;
    private String Description;
    private double UnitPrice;
    private double Discount;
    private int Quantity;
    private double Total;
    private Button btn;

    public ListsTm(String itemCode, String description, double unitPrice, double discount, int quantity, double total, Button btn) {
        setItemCode(itemCode);
        setDescription(description);
        setUnitPrice(unitPrice);
        setDiscount(discount);
        setQuantity(quantity);
        setTotal(total);
        this.setBtn(btn);
    }

    public ListsTm() {
    }

    public String getItemCode() {
        return ItemCode;
    }


    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }

    public int getQuantity() {
        return Quantity;


    }

    public void setQuantity(int quantity) {
       Quantity = quantity;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
