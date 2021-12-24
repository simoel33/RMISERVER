package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Livre;
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
	

static public ArrayList<User> filterByCategory(String category){
    ArrayList<User>	list = new ArrayList<>();
    

		try (Connection connection = init()) {
			String strSql = "SELECT * FROM users where category=?";
			
			try (PreparedStatement statement= connection.prepareStatement(strSql)) {
                       statement.setString(1, category);
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						User u = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
								resultSet.getString(4));
						list.add(u);
					}
					return list;

				}
			}

		} catch (Exception exception) {

			throw new RuntimeException(exception);

		}

    
   
}

static public ArrayList<User> filterByAdress(String address){
    ArrayList<User>	list = new ArrayList<>();
    

		try (Connection connection = init()) {
			String strSql = "SELECT * FROM users where address=?";
			
			try (PreparedStatement statement= connection.prepareStatement(strSql)) {
                       statement.setString(1, address);
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						User u = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
								resultSet.getString(4));
						list.add(u);
					}
					return list;

				}
			}

		} catch (Exception exception) {

			throw new RuntimeException(exception);

		}

    
   
}


}
