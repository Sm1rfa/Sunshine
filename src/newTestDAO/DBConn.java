package newTestDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	
	private static DBConn dbc = new DBConn();
//	public static final String url = "jdbc:mysql://localhost:3306/sunshineresort";
//	public static final String uname = "Sm1rfa";
//	public static final String pass = "19880209sgb";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	private DBConn() {
		try {
			Class.forName (DRIVER_CLASS);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection createConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/sunshineresort";
		String uname = "Sm1rfa";
		String pass = "19880209sgb";
			try {
				con = DriverManager.getConnection(url, uname, pass);
			} catch(SQLException e) {
				System.out.println("ERROR: Can't connect to Database");
			}
		return con;
	}
	
	public static Connection getConnection() {
			return dbc.createConnection();
	}
}
