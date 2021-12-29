package dao;

import javabean.User;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public User login(String userLogname, String userPwd) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        User u = null;
        String sql = "SELECT id,tel_number,identify,address " +
                "FROM user WHERE tel_number=? and pwd=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userLogname);
            pstmt.setString(2, userPwd);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                u = new User();
                u.setId(rs.getInt(1));
                u.setTelNumber(rs.getInt(2));
                u.setIdentify(rs.getInt(3));
                u.setAddress(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;

    }
}
