package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.User;

public class UserDb extends DAOContext{

	public static User findUserById(String id) {
		try (Connection connection = init()) {
			String strSql = "SELECT * FROM users WHERE id=?";
			try (PreparedStatement statement = connection.prepareStatement(strSql)) {
				statement.setString(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
					
						return new User(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
						
					} else {
						return null;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
static public void inserUser(User u) {
		
		try (Connection connection = init()) {
			String strSql = "insert into users values (?,?,?,?)";
			try (PreparedStatement statement = connection.prepareStatement(strSql)) {
				statement.setString(1, u.getId());
				statement.setString(2, u.getName());
				statement.setString(3,u.getCategory());
				statement.setString(4,u.getAdress());
				statement.executeUpdate();
			}
					
				}
		 catch ( Exception exception ) {
	            
	            throw new RuntimeException( exception );
	            
	        }
			
	
	}


static public void deleteUser(String id) {
	try (Connection connection = init()) {
		String strSql = "DELETE from users where id=?";
		try (PreparedStatement statement = connection.prepareStatement(strSql)) {

			statement.setString(1, id);
			statement.executeUpdate();
		}
	} catch (Exception exception) {

		throw new RuntimeException(exception);

	}
}
	
}
