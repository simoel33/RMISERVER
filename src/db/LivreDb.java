package db;
import java.awt.image.TileObserver;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Livre;
import beans.LivresEmpunteeByUsers;
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
		String strSql = "insert into livre_user values (?,?,?)";
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

static public Livre findBookById(int isbn) {
	Livre u=null;
	try (Connection connection = init()) {
		String strSql = "select * from livres where isbn=?";
		try (PreparedStatement statement = connection.prepareStatement(strSql)) {

			statement.setInt(1, isbn);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					 u = new Livre(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getString(4));
				}}
		}
	} catch (Exception exception) {

		throw new RuntimeException(exception);

	}
		return u;
}




static public ArrayList<LivresEmpunteeByUsers> getLivresEmpruntee(){
    ArrayList<LivresEmpunteeByUsers>	list = new ArrayList<>();
    

		try (Connection connection = init()) {

			
			try (java.sql.Statement statement = connection.createStatement()) {
				String strSql = "SELECT livres.isbn, livres.titre, users.id,users.name ,livre_user.date_retour FROM"
						+ " livres, livre_user,users where livres.isbn=livre_user.isbn and livre_user.id=users.id   ";
				try (ResultSet resultSet = statement.executeQuery(strSql)) {
					while (resultSet.next()) {
						LivresEmpunteeByUsers u = new LivresEmpunteeByUsers(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
								resultSet.getString(4),resultSet.getString(5));
						list.add(u);
					}
					return list;

				}
			}

		} catch (Exception exception) {

			throw new RuntimeException(exception);

		}

    
   
}

static public ArrayList<Livre> filterByAuthor(String auteur){
    ArrayList<Livre>	list = new ArrayList<>();
    

		try (Connection connection = init()) {
			String strSql = "SELECT * FROM livres where auteur=?";
			
			try (PreparedStatement statement= connection.prepareStatement(strSql)) {
                       statement.setString(1, auteur);
				try (ResultSet resultSet = statement.executeQuery()) {
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

static public ArrayList<Livre> filterByEditeur(String editeur){
    ArrayList<Livre>	list = new ArrayList<>();
    

		try (Connection connection = init()) {
			String strSql = "SELECT * FROM livres where editeur=?";
			
			try (PreparedStatement statement= connection.prepareStatement(strSql)) {
                       statement.setString(1, editeur);
				try (ResultSet resultSet = statement.executeQuery()) {
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


static public ArrayList<Livre> filterByTitle(String title){
    ArrayList<Livre>	list = new ArrayList<>();
    

		try (Connection connection = init()) {
			String strSql = "SELECT * FROM livres where titre=?";
			
			try (PreparedStatement statement= connection.prepareStatement(strSql)) {
                       statement.setString(1, title);
				try (ResultSet resultSet = statement.executeQuery()) {
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



}
