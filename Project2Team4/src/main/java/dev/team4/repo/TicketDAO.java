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

	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	// Select all Ticket
		public List <Ticket> selectAllTicket() {
	// create an empty array list that will hold all the Tickets returned from the database
				List<Ticket> tickets = new ArrayList<>();

		String sql = "select * from Ticket order by flight_id";
			
		// try with resources - this will auto close any resources we need without a finally block
				try (Connection conn = cu.getConnection()) {
					// prepare our statement using the connection object
					PreparedStatement ps = conn.prepareStatement(sql);
					
					// execute our statement and store the result set in a reference variable
					ResultSet rs = ps.executeQuery();
					
					// iterate over the result set, to get the values stored in each column and creating a Java Object with them
					while(rs.next()) {
						// use the getXXX() methods to retrieve the values stored in each column of this row of the result set
						int id = rs.getInt("id");
						int flight_id = rs.getInt("flight_id");
						int customer_id = rs.getInt("customer_id");
						int destination_id = rs.getInt("destination_id");
						int origin_id = rs.getInt("origin_id");
						int price = rs.getInt("price");
						
		Ticket r = new Ticket(id, flight_id, customer_id, destination_id, origin_id, price);
		tickets.add(r);
		}
		return tickets;
		
	       } catch (SQLException e) {
			e.printStackTrace();
		   }
			return null;
		}
}
