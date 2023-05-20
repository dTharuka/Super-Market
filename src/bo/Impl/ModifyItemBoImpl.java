package bo.Impl;

import bo.ModifyItemBo;
import dao.Custom.*;
import dao.Custom.Impl.ItemDaoImpl;
import dao.DAOFactory;
import entity.Item;


import java.sql.SQLException;
//============================implements ModifyItemBo===========================
public class ModifyItemBoImpl implements ModifyItemBo {


    ItemDao itemDao = (ItemDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean updateItem(Item i) throws SQLException, ClassNotFoundException {
        return itemDao.update(i);
    }

    @Override
    public Item searchItem(String text) throws SQLException, ClassNotFoundException {
        return itemDao.search(text);
    }


}
