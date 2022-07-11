package dev.team4.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.team4.models.Ticket;
import dev.team4.util.ConnectionUtil;

public class TicketDAO 
{
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	public boolean buyTicket(Ticket t)
	{
		String sql = "update ticket" + " set customer_id = ?" + " where id = ?";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, t.getCustomer_id());
			ps.setInt(2, t.getId());
			
			ps.executeUpdate();
			
			if(ps.executeUpdate() != 0)
			{
				return true;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

}
