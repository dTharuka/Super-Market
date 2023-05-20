package bo.Impl;

import bo.CustomerReportBo;
import dao.Custom.*;
import dao.Custom.Impl.CustomerDaoImpl;
import dao.Custom.Impl.OrderDaoImpl;
import dao.DAOFactory;
import dto.CustomDTO;
import dto.OrderDTO;
import entity.Customer;
import entity.Orders;


import java.sql.SQLException;
import java.util.ArrayList;
//=============================implements CustomerReportBo===================
public class CustomerReportBoImpl implements CustomerReportBo {

    OrderDao orderDao= (OrderDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    CustomerDao customerDao= (CustomerDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);



    @Override
    public ArrayList<CustomDTO> getOrderDetails() throws SQLException, ClassNotFoundException {
        ArrayList<CustomDTO> customDTOS=new ArrayList<>();
        ArrayList<Orders> data = orderDao.getData();
        for (Orders o : data) {
            customDTOS.add(new CustomDTO(o.getCustId(),o.getCost()));
        }
        return customDTOS;
    }

    @Override
    public ArrayList<CustomDTO> getCustomerName() throws SQLException, ClassNotFoundException {
        ArrayList<CustomDTO> customDTOS=new ArrayList<>();
        ArrayList<Customer> name = customerDao.getName();
        for (Customer customer : name) {
            customDTOS.add(new CustomDTO(customer.getCustomerName(),customer.getCustomerId()));
        }
       return customDTOS;
    }
}
