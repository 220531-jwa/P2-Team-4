package dev.team4.repo;

import dev.team4.models.Ticket;
import dev.team4.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TicketDAO {

    private static final ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    // Select all Ticket
    public List<Ticket> selectAllTicket() {
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
            while (rs.next()) {
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

    public boolean deleteTicket(int id) {
        String sql = "delete from public.ticket where id = ? returning *";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updatePriceTicket(Ticket t) {

        String sql = "update ticket" + " set price = ?" + " where id = ?";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, t.getPrice());
            ps.setInt(2, t.getFlight_id());

            ps.executeUpdate();

            if (ps.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<Ticket> getAllCustomersTickets(int id) {
        String sql = "select * from ticket where customer_id = ?";
        List<Ticket> tickets = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                tickets.add(new Ticket(
                        rs.getInt("id"),
                        rs.getInt("flight_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("origin_id"),
                        rs.getInt("destination_id"),
                        rs.getInt("price")
                ));
            }
            return tickets;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
