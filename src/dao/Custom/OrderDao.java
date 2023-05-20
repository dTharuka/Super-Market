package dao.Custom;

import dao.CrudDAO;
import dto.CustomDTO;
import entity.Customer;
import entity.Orders;

import java.sql.SQLException;
import java.util.ArrayList;
//========================extends CrudDAO==============================
public interface OrderDao extends CrudDAO<Orders,String> {


    String getOrderId() throws SQLException, ClassNotFoundException;

    ArrayList<CustomDTO> getMonthlyIncome() throws SQLException, ClassNotFoundException;

    ArrayList<Orders> getData() throws SQLException, ClassNotFoundException;

}
