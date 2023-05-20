package bo.Impl;

import bo.NewItemBo;
import dao.CrudDAO;
import dao.Custom.*;
import dao.Custom.Impl.ItemDaoImpl;
import dao.DAOFactory;
import entity.Item;


import java.sql.SQLException;
//=========================implements NewItemBo====================================
public class NewItemBoImpl implements NewItemBo {

    ItemDao itemDao = (ItemDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean SaveItems(Item i) throws SQLException, ClassNotFoundException {
        return itemDao.add(i);
    }
}
