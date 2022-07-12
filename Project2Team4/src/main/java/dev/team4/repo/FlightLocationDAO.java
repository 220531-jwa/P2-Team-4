package dev.team4.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dev.team4.models.FlightLocation;
import dev.team4.util.ConnectionUtil;

public class FlightLocationDAO 
{
	
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	public FlightLocationDAO()
	{
		
	}
	
	public boolean updateDescription(FlightLocation fl)
	{
		String sql = "update flight_location" + " set description = ?" + " where id = ?";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, fl.getFlightDescription());
			ps.setInt(2, fl.getFlightId());
			
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
