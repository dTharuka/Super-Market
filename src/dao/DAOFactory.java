package dao;

import dao.Custom.Impl.CustomerDaoImpl;
import dao.Custom.Impl.ItemDaoImpl;
import dao.Custom.Impl.OrderDaoImpl;
import dao.Custom.Impl.OrderDetailDaoImpl;
import dao.Custom.Impl.QueryDaoImpl;
//====================Object Hiding======================
public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    //factory method
    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ITEM:
                return new ItemDaoImpl();
            case ORDER:
                return new OrderDaoImpl();
            case ORDERDETAILS:
                return new OrderDetailDaoImpl();
            case QUERYDAO:
                return new QueryDaoImpl();
            default:
                return null;
        }
    }

    public enum DAOTypes {
        CUSTOMER, ITEM, ORDER, ORDERDETAILS, QUERYDAO
    }
}
