package dev.team4.repo;

import dev.team4.models.User;
import dev.team4.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public User GetUserByUserName(String username) {
        String sql = "select * from public.user where username = ?";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getBoolean("isadmin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
