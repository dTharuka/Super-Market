package dao.Custom;

import dao.CrudDAO;
import db.DbConnection;
import entity.Customer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//==============================extends CrudDAO=====================================
public interface CustomerDao extends CrudDAO<Customer,String>{

    public List<String> getCustomerIds() throws SQLException, ClassNotFoundException;

    public Customer getCustomer(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<Customer> getName() throws SQLException, ClassNotFoundException;

}
