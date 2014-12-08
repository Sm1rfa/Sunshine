package newTestDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import newTestDomain.Cottage;

public class DBCottageHandler {
	
	public ArrayList<Cottage> getCottage() {
		Statement s = null;
		Connection con = null;
		ResultSet rs = null;
		Cottage cottage = null;
		String query = "SELECT * FROM Cottage";
		ArrayList<Cottage> ctgInfo = null;
		ctgInfo = new ArrayList<Cottage>();
			try {
				con = DBConn.getConnection();
				s = con.createStatement();
				rs = s.executeQuery(query);
					if(rs != null) {
						while(rs.next()) {
							cottage = new Cottage(rs.getInt("cottageNO"), rs.getString("cottageType"),
									rs.getInt("numberOfBeds"), rs.getString("cottageStatus"), rs.getDouble("cottagePrice"));
							ctgInfo.add(cottage);
						}
					} else {
						System.err.println("Your database is empty!");
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
		
		return ctgInfo;
	}
	
	public static void insertCottage(Cottage c) {
		PreparedStatement ps = null;
		Connection con = null;
		
			try {
				con = DBConn.getConnection();
				ps = (PreparedStatement) con.prepareStatement("INSERT INTO Cottage(cottageType, numberOfBeds, cottageStatus, cottagePrice) VALUES (?, ?, ?, ?)");
				ps.setString(1, c.getCottageType());
				ps.setInt(2, c.getNumberOfBeds());
				ps.setString(3, c.getCottageStatus());
				ps.setDouble(4, c.getCottagePrice());
				ps.executeUpdate();
				System.out.println("Your new cottage is saved!");
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
	
	public static void delCottage(int cottageid2) {
		Statement s = null;
		Connection con = null;
		String query = null;
		
			try {
				con = DBConn.getConnection();
				s = con.createStatement();
				 query = "DELETE FROM Cottage WHERE cottageNO = '35'";
				 	s.executeUpdate(query);
				 query = "DELETE FROM Cottage WHERE cottageNO = '36'";
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
