package newTestDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import newTestDomain.Address;
import newTestDomain.Guest;

public class DBGuestHandler {
	
	public ArrayList<Guest> getGuests() {
		Statement s = null;
		Connection con = null;
		ResultSet rs = null;
		Guest guest = null;
		String query = "SELECT * FROM Guest";
		ArrayList<Guest> guestInfo = null;
		guestInfo = new ArrayList<Guest>();
			try {
				con = DBConn.getConnection();
				s = con.createStatement();
				rs = s.executeQuery(query);
					if(rs != null) {
						while(rs.next()) {
							guest = new Guest(rs.getInt("guestNO"), rs.getString("fName"), 
									rs.getString("lName"), rs.getString("street"), 
										rs.getString("zip"));
							guestInfo.add(guest);
						}
					} else {
						System.err.println("Your database is empty!!!"); 
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
		
		return guestInfo;
	}
	
	public static void insertGuest(Guest g) {
		PreparedStatement s = null;
		Connection con = null;
		
			try {
				con = DBConn.getConnection();
				s = (PreparedStatement) con.prepareStatement("INSERT INTO Guest (fname, lname, street, zip) VALUES (?, ?, ?, ?)");
					s.setString(1, g.getfName());
					s.setString(2, g.getlName());
					s.setString(3, g.getStreetName());
					s.setString(4, g.getPostCode());
					s.executeUpdate();
					System.out.println("Saved guest");
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
	
	public static void insertAddress(Address a) {
		PreparedStatement s = null;
		Connection con = null;
		
		try {
			con = DBConn.getConnection();
			s = (PreparedStatement) con.prepareStatement("INSERT INTO Address (zip, city, country) VALUES (?, ?, ?)");
				s.setString(1, a.getZipcode());
				s.setString(2, a.getCity());
				s.setString(3, a.getCountry());
				s.executeUpdate();
				System.out.println("Saved address");
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
	
	public static void delGuest(int guestNO) {
		Statement s = null;
		Connection con = null;
		String query = null;
		
			try {
				con = DBConn.getConnection();
				s = con.createStatement();
					query = "DELETE FROM Guest WHERE guestNO = " + guestNO;
				s.executeUpdate(query);
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
