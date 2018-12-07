package system.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validate {
	private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/jcg";
	private static final String USER = "root";
	private static final String PASSWORD = "Qwerty1992";
	private static final String DB_NAME = "com.mysql.cj.jdbc.Driver";
	private static Connection conn = null;
	public static boolean checkUser(String email, String password) throws SQLException {
		boolean st = false;
		
		try {
			Class.forName(DB_NAME);
			conn = DriverManager.getConnection(CONNECTION_URL, USER, PASSWORD);
			PreparedStatement ps = conn.prepareStatement("Select * from student where email = ? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			st = rs.next();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return st;
	}
	public static String getUserNameIfExist(String email,String password) throws SQLException {
		String result = "";
		try {
			Class.forName(DB_NAME);
			conn = DriverManager.getConnection(CONNECTION_URL, USER, PASSWORD);
			PreparedStatement ps = conn.prepareStatement("Select * from student where email = ? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                // Read values using column name
                String name = rs.getString("name");
                result = name;
                System.out.println("Username is " + result);
                }
			//result = rs.getString("name");
			//System.out.println("Username is " + result);
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return result;
	}
}
