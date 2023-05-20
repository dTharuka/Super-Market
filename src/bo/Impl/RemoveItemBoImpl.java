package bo.Impl;

import bo.RemoveItemBo;
import dao.CrudDAO;
import dao.Custom.*;
import dao.Custom.Impl.ItemDaoImpl;
import dao.DAOFactory;
import entity.Item;


import java.sql.SQLException;
//==========================implements RemoveItemBo========================
public class RemoveItemBoImpl implements RemoveItemBo {

    ItemDao itemDao = (ItemDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public Item searchItem(String text) throws SQLException, ClassNotFoundException {
        return itemDao.search(text);
    }

    @Override
    public boolean deleteItem(String text) throws SQLException, ClassNotFoundException {
        return itemDao.delete(text);
    }
}
