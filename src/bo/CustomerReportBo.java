package bo;

import dto.CustomDTO;
import dto.OrderDTO;


import java.sql.SQLException;
import java.util.ArrayList;
//========================extends SuperBo==========================
public interface CustomerReportBo extends SuperBo{
    ArrayList<CustomDTO> getOrderDetails() throws SQLException, ClassNotFoundException;

    ArrayList<CustomDTO> getCustomerName() throws SQLException, ClassNotFoundException;
}
