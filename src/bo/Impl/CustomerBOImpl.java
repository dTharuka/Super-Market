package bo.Impl;

import bo.CustomerBo;
import dao.Custom.*;
import dao.Custom.Impl.CustomerDaoImpl;
import dao.Custom.Impl.OrderDaoImpl;
import dao.DAOFactory;
import dto.CustomerDTO;
import entity.Customer;

import java.sql.SQLException;

//===========================================implements CustomerBo============================
public class CustomerBOImpl implements CustomerBo {

    CustomerDao customerDao= (CustomerDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);


    @Override
    public boolean addCustomer(CustomerDTO c1) throws SQLException, ClassNotFoundException {
        return customerDao.add(new Customer(c1.getId(),c1.getTittle(),c1.getName(),c1.getAddress(),c1.getCity(),c1.getProvince(),c1.getPostalCode()));
    }
}
