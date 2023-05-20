package dao.Custom;

import dao.SuperDAO;
import dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;
//=============================extends CrudDAO==============================
public interface QueryDao extends SuperDAO {
    public ArrayList<CustomDTO> getDailyItemIncome() throws SQLException, ClassNotFoundException;

    public ArrayList<CustomDTO> getMonthlyOrderIncome() throws SQLException, ClassNotFoundException;

    public ArrayList<CustomDTO> getYearlyOrderIncome() throws SQLException, ClassNotFoundException;
}
