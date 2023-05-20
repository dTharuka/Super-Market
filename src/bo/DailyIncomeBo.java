package bo;



import dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;
//============================extends SuperBo===================================
public interface DailyIncomeBo extends SuperBo{

    ArrayList<CustomDTO> getdailyItems() throws SQLException, ClassNotFoundException;

    ArrayList<CustomDTO> getDailyItemsIncome() throws SQLException, ClassNotFoundException;
}
