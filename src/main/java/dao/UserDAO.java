package dao;

import javabean.User;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    public void register(User user) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO user(tel_number,pwd," +
                "identify,address" +
                ") VALUES(?,?,?,?)    ";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, user.getTelNumber());
            pstmt.setString(2, user.getPwd());
            pstmt.setInt(3, user.getIdentify());
            pstmt.setString(4, user.getAddress());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            DBUtil.closeJDBC(null,pstmt,conn);
            e.printStackTrace();
        }
    }
}
