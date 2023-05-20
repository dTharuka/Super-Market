package bo.Impl;

import bo.YearlyIncomeBo;
import dao.Custom.*;
import dao.Custom.Impl.OrderDaoImpl;
import dao.DAOFactory;
import dto.CustomDTO;


import java.sql.SQLException;
import java.util.ArrayList;
//===============================implements YearlyIncomeBo=====================================
public class YearlyIncomeBoImpl implements YearlyIncomeBo {
    OrderDao orderDao= (OrderDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    QueryDao queryDao= (QueryDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.QUERYDAO);

    @Override
    public ArrayList<CustomDTO> getMonthlyIncome() throws SQLException, ClassNotFoundException {
        return orderDao.getMonthlyIncome();
    }

    @Override
    public ArrayList<CustomDTO> getYearlyOrderIncome() throws SQLException, ClassNotFoundException {
        return queryDao.getYearlyOrderIncome();
    }
}
