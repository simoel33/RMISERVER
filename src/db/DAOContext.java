package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAOContext {

	protected static String urldb;
	protected static String userdb;
	
	public static Connection init() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			urldb="jdbc:mysql://localhost/biblio";
			userdb="root";
			Connection connection = DriverManager.getConnection(urldb, userdb, "");
			System.out.println("connection etavli");
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
