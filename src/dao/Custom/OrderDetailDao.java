package dao.Custom;

import dao.CrudDAO;
import db.DbConnection;
import entity.OrderDetail;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//=============================extends CrudDAO=======================
public interface OrderDetailDao extends CrudDAO<OrderDetail,String>{

}
