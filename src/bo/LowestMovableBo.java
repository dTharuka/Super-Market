package bo;

import dto.OrderDetailDTO;


import java.sql.SQLException;
import java.util.ArrayList;
//============================extends SuperBo==============================
public interface LowestMovableBo extends SuperBo{
    ArrayList<OrderDetailDTO> getAllOrderDetails() throws SQLException, ClassNotFoundException;
}
