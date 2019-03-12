package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jdbc","sa","passw0rd");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");
			while(rs.next()) {
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
