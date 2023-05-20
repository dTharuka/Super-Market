package db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
//=======================Use Singleton====================================
public class DbConnection {
    private static DbConnection dbConnection;
    private Connection connection;

    private DbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:Mysql://127.0.0.1:3307/SuperMarket","root","1234");
    }

    public static DbConnection getInstance() throws SQLException, ClassNotFoundException {
        if(dbConnection==null){
         dbConnection=new DbConnection();
         return dbConnection;
        }
        return dbConnection;

    }

    public Connection getConnection(){
    return connection;
    }

}
