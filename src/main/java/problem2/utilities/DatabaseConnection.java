package problem2.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public static Connection provideConnection() {
		
		String url = "jdbc:mysql://localhost:3306/db1";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, "root", "jatin");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
