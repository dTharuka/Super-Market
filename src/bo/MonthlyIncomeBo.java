package bo;

import dto.CustomDTO;


import java.sql.SQLException;
import java.util.ArrayList;
//===========================extends SuperBo=================================
public interface MonthlyIncomeBo extends SuperBo{
    ArrayList<CustomDTO> getMonthlyIncome() throws SQLException, ClassNotFoundException;

    ArrayList<CustomDTO> getMonthlyOrderIncome() throws SQLException, ClassNotFoundException;
}
