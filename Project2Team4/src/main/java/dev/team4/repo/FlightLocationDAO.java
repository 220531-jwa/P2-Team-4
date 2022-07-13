package dev.team4.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.team4.models.FlightLocation;
import dev.team4.util.ConnectionUtil;

public class FlightLocationDAO {

	// CONNECTIONUTIL.JAVA CONNECTION
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	// CREATE FLIGHT LOCATION
	public FlightLocation createFlightLocation(String city, String country, String description) {
		String sql = "insert into public.flight_location values (default, ?, ?, ?) returning *;";
		try (Connection connect = cu.getConnection()) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, city);
			ps.setString(2, country);
			ps.setString(3, description);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new FlightLocation(rs.getInt("id"), rs.getString("city"), rs.getString("country"),
						rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// GET ALL FLIGHT LOCATIONS
	public List<FlightLocation> getAllFlightLocations() {
		List<FlightLocation> flightlocation = new ArrayList<>();
		String sql = "select * from public.flight_location";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String city = rs.getString("city");
				String country = rs.getString("country");
				String description = rs.getString("description");
				FlightLocation fl = new FlightLocation(id, city, country, description);
				flightlocation.add(fl);
			}
			return flightlocation;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// GET FLIGHT LOCATION ID
	public FlightLocation getFlightLocationById(int id) {
		String sql = "select * from public.flight_location where id = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new FlightLocation(rs.getInt("id"), rs.getString("city"), rs.getString("country"),
						rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// UPDATE DESCRIPTION
	public boolean updateDescription(FlightLocation fl) {
		String sql = "update flight_location" + " set description = ?" + " where id = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fl.getDescription());
			ps.setInt(2, fl.getId());
			ps.executeUpdate();
			if (ps.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
//	public FlightLocation updateDescription(int id, String description) {
//		String sql = "update public.flight_location set description = ? where id = ? returning *;";
//		try (Connection connect = cu.getConnection()) {
//			PreparedStatement ps = connect.prepareStatement(sql);
//			ps.setString(1, description);
//			ps.setInt(2, id);
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				return new FlightLocation(rs.getInt("id"), rs.getString("city"), rs.getString("country"),
//						rs.getString("description"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	// DELETE FLIGHT LOCATION
	public void deleteFlightLocation(int id) {
		String sql = "delete from public.flight_location where id = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}