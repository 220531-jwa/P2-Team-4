package dev.team4.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import dev.team4.models.Flight;
import dev.team4.models.User;
import dev.team4.util.ConnectionUtil;

public class UserDAO {

	// CONNECTIONUTIL.JAVA CONNECTION
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	// CREATE USER
	public User createUser(User u) {
		String sql = "insert into public.user (default, ?, ?, ?) returning *";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ps.setString(2, u.getUserUserName());
			ps.setString(3, u.getUserPassword());
			ps.setBoolean(4, u.getAdmin());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("UserUserName"), rs.getString("UserPassword"),
						rs.getBoolean("isAdmin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// CREATE FLIGHT
	public Flight createFlight(Flight flight) {
		String sql = "insert into flight values(default, ?, ?, ?) returning *";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, flight.getAirline());
			ps.setTime(2, Time.valueOf(flight.getArriving()));
			ps.setTime(3, Time.valueOf(flight.getDeparting()));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Flight(rs.getInt(1), rs.getString(2), LocalTime.parse(rs.getTime(3).toString()),
						LocalTime.parse(rs.getTime(4).toString()));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	// GET ALL USERS
	public List<User> getAllUsers() {
		List<User> user = new ArrayList<>();
		String sql = "select * from public.user";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String userUserName = rs.getString("username");
				String userPassword = rs.getString("pass");
				Boolean isAdmin = rs.getBoolean("isadmin");
				User u = new User(id, userUserName, userPassword, isAdmin);
				user.add(u);
			}
			return user;
		} catch (SQLException u) {
			u.printStackTrace();
		}
		return null;
	}

	// GET USER ID
	public User getUserById(int id) {
		String sql = "select * from public.user where id = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("userUserName"), rs.getString("userPassword"),
						rs.getBoolean("userPassword"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// GET USERNAME
	public User getUserUserName(String userUserName) {
		String sql = "select * from public.user where username = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userUserName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("username"), rs.getString("pass"),
						rs.getBoolean("isadmin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// UPDATE USER
	public boolean updateUser(User u) {
		String sql = "update public.user set " + "username = ?, " + "pass = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUserUserName());
			ps.setString(2, u.getUserPassword());
			ps.executeUpdate();
			if (ps.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// DELETE USER

	public void deleteUser(int id) {
		String sql = "delete from user where id = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}