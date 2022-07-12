package dev.team4.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.team4.models.Flight;
import dev.team4.util.ConnectionUtil;

public class FlightDAO {

	// CONNECTIONUTIL.JAVA CONNECTION
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	// CREATE FLIGHT
	public Flight createFlight(int id, String airline, String arriving, String departing) {
		String sql = "insert into public.flight values (default, ?, ?, ?) returning *;";
		try (Connection connect = cu.getConnection()) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, airline);
			ps.setString(3, arriving);
			ps.setString(4, departing);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Flight(rs.getInt("id"), rs.getString("airline"), rs.getString("arriving"),
						rs.getString("isAdmin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// GET ALL FLIGHTS
	public List<Flight> getAllFlights() {
		List<Flight> flight = new ArrayList<>();
		String sql = "select * from public.flight";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String airline = rs.getString("airline");
				String arriving = rs.getString("arriving");
				String departing = rs.getString("departing");
				Flight f = new Flight(id, airline, arriving, departing);
				flight.add(f);
			}
			return flight;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// GET FLIGHT ID
	public Flight getFlightById(int id) {
		String sql = "select * from public.flight where id = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Flight(rs.getInt("id"), rs.getString("airline"), rs.getString("arriving"),
						rs.getString("departing"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// UPDATE FLIGHT
	public Flight updateFlight(int id, String airline, String arriving, String departing) {
		String sql = "update public.flight set airline = ? and arriving = ? and departing where id = ? returning *;";
		try (Connection connect = cu.getConnection()) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, airline);
			ps.setString(3, arriving);
			ps.setString(4, departing);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Flight(rs.getInt("id"), rs.getString("airline"), rs.getString("arriving"),
						rs.getString("departing"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// DELETE FLIGHT
	public void deleteFlight(int id) {
		String sql = "delete from public.flight where id = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}