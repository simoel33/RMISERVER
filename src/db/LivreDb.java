package db;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Livre;
import beans.User;

public class LivreDb extends DAOContext{
	
	static public ArrayList<Livre> getBooks(){
	     ArrayList<Livre>	list = new ArrayList<>();
	     

			try (Connection connection = init()) {

				
				try (java.sql.Statement statement = connection.createStatement()) {
					String strSql = "SELECT * FROM livres where livres.isbn not in (select isbn from livre_user) ";
					try (ResultSet resultSet = statement.executeQuery(strSql)) {
						while (resultSet.next()) {
							Livre u = new Livre(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
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
	
static public void inserBook(Livre u) {
		
		try (Connection connection = init()) {
			String strSql = "insert into livres values (?,?,?,?)";
			try (PreparedStatement statement = connection.prepareStatement(strSql)) {
				
				statement.setInt(1, u.getIsbn());
				statement.setString(2, u.getTitle());
				statement.setString(3,u.getAuteur());
				statement.setString(4,u.getEditeur());
				statement.executeUpdate();
			}
					
				}
		 catch ( Exception exception ) {
	            
	            throw new RuntimeException( exception );
	            
	        }
			
	
	}


static public void emprunter(Livre v,User u,String date) {
	
	try (Connection connection = init()) {
		String strSql = "insert into livre_user values (?,?,?,?)";
		try (PreparedStatement statement = connection.prepareStatement(strSql)) {
			
			statement.setInt(1, v.getIsbn());
			statement.setString(2, u.getId());
			statement.setString(3,date);
			statement.executeUpdate();
		}
				
			}
	 catch ( Exception exception ) {
            
            throw new RuntimeException( exception );
            
        }
		

}


static public void deleteBook(int isbn) {
	try (Connection connection = init()) {
		String strSql = "DELETE from livres where isbn=?";
		try (PreparedStatement statement = connection.prepareStatement(strSql)) {

			statement.setInt(1, isbn);
			statement.executeUpdate();
		}
	} catch (Exception exception) {

		throw new RuntimeException(exception);

	}
}


}
