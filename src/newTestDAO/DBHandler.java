package newTestDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import newTestDomain.Booking;

public class DBHandler {
	
	public ArrayList<Booking> getBooking() {
		Statement s = null;
		Connection con = null;
		Booking booking = null;
		String query = "SELECT * FROM Booking";
		ArrayList<Booking> book = null;
		book = new ArrayList<Booking>();
		
			try {
				con = DBConn.getConnection();
				s = con.createStatement();
				ResultSet rs = s.executeQuery(query);
				if(rs != null) {
					while(rs.next()) {
						booking = new Booking(rs.getInt("bookingNO"), rs.getInt("staffNO"), rs.getInt("guestNO"), 
								rs.getInt("cottageNO"), rs.getInt("fromWeek"), rs.getInt("weeks"));
						book.add(booking);
					}
				}	
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				if(con != null) {
					try {
						con.close();
					} catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
			return book;
	}
	
	public static void insertBooking(Booking b) {
		PreparedStatement ps = null;
		Connection con = null;
		
			try {
				con = DBConn.getConnection();
				ps = con.prepareStatement("INSERT INTO Booking(bookingNO, staffNO, guestNO, cottageNO, fromWeek, weeks) VALUES(?, ?, ?, ?, ?, ?)");
				ps.setInt(1, b.getBookingNO());
				ps.setInt(2, b.getStaffNO());
				ps.setInt(3, b.getGuestNO());
				ps.setInt(4, b.getCottageNO());
				ps.setInt(5, b.getDateFrom());
				ps.setInt(6, b.getDateTo());
				ps.executeUpdate();
				System.out.println("Your booking is saved!");
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				if(con != null) {
					try {
						con.close();
					} catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
	}
}