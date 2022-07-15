package dev.team4.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import dev.team4.models.Flight;
import dev.team4.util.ConnectionUtil;

public class FlightDAO {

	// CONNECTIONUTIL.JAVA CONNECTION
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	// CREATE FLIGHT
	public Flight createFlight(Flight flight) {
		String sql = "insert into public.flight values(default, ?, ?, ?) returning *";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, flight.getAirline());
			ps.setTime(2, flight.getArrival());
			ps.setTime(3, flight.getDeparture());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Flight(rs.getInt("id"), rs.getString("airline"), rs.getTime("arrival"),
						rs.getTime("departure"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

//	public Flight createFlight(String airline, String arriving, String departing) {
//		String sql = "insert into public.flight values (default, ?, ?, ?) returning *;";
//		try (Connection connect = cu.getConnection()) {
//			PreparedStatement ps = connect.prepareStatement(sql);
//			ps.setString(1, airline);
//			ps.setTime(2, arriving);
//			ps.setTime(3, departing);
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				return new Flight(rs.getInt("id"), rs.getString("airline"), rs.getTime("arriving"),
//						rs.getTime("departing"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

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
				Time arrival = rs.getTime("arrival");
				Time departure = rs.getTime("departure");
				Flight f = new Flight(id, airline, arrival, departure);
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
				return new Flight(rs.getInt("id"), rs.getString("airline"), rs.getTime("arrival"),
						rs.getTime("departure"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// UPDATE AIRLINE
	public Flight updateAirline(int id, String airline) {
		String sql = "update public.flight set airline = ? where id = ? returning *;";
		try (Connection connect = cu.getConnection()) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, airline);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Flight(rs.getInt("id"), rs.getString("airline"), rs.getTime("arrival"),
						rs.getTime("departure"));
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