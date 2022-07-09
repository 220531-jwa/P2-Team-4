package dev.team4.repo;

import dev.team4.models.Flight;
import dev.team4.models.User;
import dev.team4.util.ConnectionUtil;

import java.sql.*;
import java.time.LocalTime;

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

    public Flight createFlight(Flight flight) {
        String sql = "insert into flight values(default, ?, ?, ?) returning *";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, flight.getAirline());
            ps.setTime(2, Time.valueOf(flight.getArriving()));
            ps.setTime(3, Time.valueOf(flight.getDeparting()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Flight(
                        rs.getInt(1),
                        rs.getString(2),
                        LocalTime.parse(rs.getTime(3).toString()),
                        LocalTime.parse(rs.getTime(4).toString())
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
