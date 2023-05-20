package bo.Impl;

import bo.BoFactory;
import bo.MonthlyIncomeBo;
import dao.Custom.*;
import dao.Custom.Impl.OrderDaoImpl;
import dao.DAOFactory;
import dto.CustomDTO;


import java.sql.SQLException;
import java.util.ArrayList;
//==============================implements MonthlyIncomeBo=======================
public class MonthlyIncomeBoImpl implements MonthlyIncomeBo {


    OrderDao orderDao= (OrderDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    QueryDao queryDao= (QueryDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.QUERYDAO);



    @Override
    public ArrayList<CustomDTO> getMonthlyIncome() throws SQLException, ClassNotFoundException {
        return orderDao.getMonthlyIncome();
    }

    @Override
    public ArrayList<CustomDTO> getMonthlyOrderIncome() throws SQLException, ClassNotFoundException {
        return queryDao.getMonthlyOrderIncome();
    }
}
