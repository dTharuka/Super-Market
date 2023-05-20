package dao.Custom;

import dao.CrudDAO;
import dto.CustomDTO;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
//==========================extends CrudDAO=================================
public interface ItemDao extends CrudDAO<Item,String> {


    public ArrayList<String> getItemCodes() throws SQLException, ClassNotFoundException;

    public boolean updateQty(String itemCode, int qty) throws SQLException, ClassNotFoundException;

    public ArrayList<CustomDTO> dailyItem() throws SQLException, ClassNotFoundException;


}
