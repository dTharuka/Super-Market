package bo;



import entity.Item;

import java.sql.SQLException;
//================================extends SuperBo==========================
public interface NewItemBo extends SuperBo{
    boolean SaveItems(Item i) throws SQLException, ClassNotFoundException;
}
