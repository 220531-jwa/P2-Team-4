package dev.team4.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.team4.models.Ticket;
import dev.team4.util.ConnectionUtil;

public class TicketDAO {

	// CONNECTIONUTIL.JAVA CONNECTION
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	// CREATE TICKET
	public Ticket createTicket(int customer_id, int flight_id, int origin_id, int destination_id, int price) {
		String sql = "insert into public.ticket values (default, ?, ?, ?, ?, ?) returning *;";
		try (Connection connect = cu.getConnection()) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, customer_id);
			ps.setInt(2, flight_id);
			ps.setInt(3, origin_id);
			ps.setInt(4, destination_id);
			ps.setInt(5, price);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Ticket(rs.getInt("id"), rs.getInt("customer_id"), rs.getInt("flight_id"),
						rs.getInt("origin_id"), rs.getInt("destination_id"), rs.getInt("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// GET ALL TICKETS
	public List<Ticket> getAllTickets() {
		List<Ticket> ticket = new ArrayList<>();
		String sql = "select * from public.ticket";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int customer_id = rs.getInt("customer_id");
				int flight_id = rs.getInt("flight_id");
				int origin_id = rs.getInt("origin_id");
				int destination_id = rs.getInt("destination_id");
				int price = rs.getInt("price");
				Ticket t = new Ticket(id, customer_id, flight_id, origin_id, destination_id, price);
				ticket.add(t);
			}
			return ticket;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// GET TICKET ID
	public Ticket getTicketById(int id) {
		String sql = "select * from public.ticket where id = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Ticket(rs.getInt("id"), rs.getInt("customer_id"), rs.getInt("flight_id"),
						rs.getInt("origin_id"), rs.getInt("destination_id"), rs.getInt("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// UPDATE TICKET PRICE
	public Ticket updateTicketPrice(int id, int price) {
		String sql = "update public.ticket set price = ? where id = ? returning *;";
		try (Connection connect = cu.getConnection()) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, price);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Ticket(rs.getInt("id"), rs.getInt("customer_id"), rs.getInt("flight_id"),
						rs.getInt("origin_id"), rs.getInt("destination_id"), rs.getInt("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// DELETE TICKET
	public void deleteTicket(int id) {
		String sql = "delete from public.ticket where id = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// BUY TICKET
	public boolean buyTicket(Ticket t) {
		String sql = "update ticket" + " set customer_id = ?" + " where id = ?";

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, t.getCustomer_id());
			ps.setInt(2, t.getId());

			ps.executeUpdate();

			if (ps.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}