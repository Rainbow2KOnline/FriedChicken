package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabean.Order;
import utils.DBUtil;
public class RiderDao {
    public List<Order> selectAll() {
        List<Order> list = new ArrayList<Order>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "SELECT id,rider_id,user_id,sub_order_id, status,company_state,address "
                + "FROM order ORDER BY id DESC";
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Order order = new Order();
                order.setId(rs.getLong(1));
                order.setUserid(rs.getLong(2));
                order.setSubOrderid(rs.getLong(3));
                order.setStatus(rs.getLong(4));
                order.setAddress(rs.getString(5));
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
