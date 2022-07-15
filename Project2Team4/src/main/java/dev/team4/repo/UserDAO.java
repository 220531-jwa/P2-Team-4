package dev.team4.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.team4.models.User;
import dev.team4.util.ConnectionUtil;

public class UserDAO {

	// CONNECTIONUTIL.JAVA CONNECTION
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	// CREATE USER
	public User createUser(String username, String pass, Boolean isAdmin) {
		String sql = "insert into public.user values (default, ?, ?, ?) returning *;";
		try (Connection connect = cu.getConnection()) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pass);
			ps.setBoolean(3, isAdmin);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("username"), rs.getString("pass"),
						rs.getBoolean("isAdmin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
				String username = rs.getString("username");
				String pass = rs.getString("pass");
				Boolean isAdmin = rs.getBoolean("isadmin");
				User u = new User(id, username, pass, isAdmin);
				user.add(u);
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
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
				return new User(rs.getInt("id"), rs.getString("username"), rs.getString("pass"),
						rs.getBoolean("isAdmin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// UPDATE PASSWORD
	public User updatePassword(int id, String pass) {
		String sql = "update public.user set pass = ? where id = ? returning *;";
		try (Connection connect = cu.getConnection()) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("username"), rs.getString("pass"),
						rs.getBoolean("isAdmin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// DELETE USER
	public void deleteUser(int id) {
		String sql = "delete from public.user where id = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User getUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}