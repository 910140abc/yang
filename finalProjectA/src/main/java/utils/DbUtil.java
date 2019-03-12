package utils;

import java.sql.*;


public class DbUtil {
	
	public static Connection getConnection() throws ClassNotFoundException {
		Connection conn = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=MyDatabase";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
			System.out.println("success");
		} catch (SQLException e) {			
			System.out.println(e);
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(PreparedStatement pstmt) throws SQLException {
		
		pstmt.close();
	}

	public static void close(Connection conn) throws SQLException {
		conn.close();
		
	}
	

}
