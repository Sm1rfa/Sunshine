package newTestDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import newTestDomain.Staff;

public class DBStaffHandler {
	
	public ArrayList<Staff> getStaff() {
		Statement s = null;
		Connection con = null;
		ResultSet rs = null;
		Staff staff = null;
		String query = "SELECT * FROM Staff";
		ArrayList<Staff> staffInfo = null;
		staffInfo = new ArrayList<Staff>();
			try {
				con = DBConn.getConnection();
				s = con.createStatement();
				rs = s.executeQuery(query);
					if(rs != null) {
						while(rs.next()) {
							staff = new Staff(rs.getInt("staffNO"), rs.getString("fName"), 
									rs.getString("lName"), rs.getString("position"), rs.getString("DOB"));
							staffInfo.add(staff);
						}
					} else {
						System.out.println("You database is empty!");
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
		return staffInfo;
	}
	
	public static void insertStaff(Staff s) {
		PreparedStatement ps = null;
		Connection con = null;
		
			try {
				con = DBConn.getConnection();
				ps = (PreparedStatement) con.prepareStatement("INSERT INTO Staff(fname, lname, position, DOB) VALUES(?, ?, ?, ?)");
				ps.setString(1, s.getfName());
				ps.setString(2, s.getlName());
				ps.setString(3, s.getPosition());
				ps.setString(4, s.getDOB());
				ps.executeUpdate();
				System.out.println("The staff is saved!");
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
