package bo.Impl;

import bo.MostMovableItemBo;
import dao.Custom.*;
import dao.Custom.Impl.OrderDetailDaoImpl;
import dao.DAOFactory;
import entity.OrderDetail;


import java.sql.SQLException;
import java.util.ArrayList;
//==================================implements MostMovableItemBo=============================
public class MostMovableItemBoImpl implements MostMovableItemBo {

    OrderDetailDao orderDetailDao = (OrderDetailDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);

    @Override
    public ArrayList<OrderDetail> getAllOrderDetails() throws SQLException, ClassNotFoundException {
        return orderDetailDao.getAll();
    }
}
