package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import beans.Livre;
import beans.LivresEmpunteeByUsers;
import beans.User;
import db.LivreDb;
import db.UserDb;

public class ServiceImp extends UnicastRemoteObject implements IBiblio {

	public ServiceImp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2412089131938498839L;

	@Override
	public ArrayList<Livre> getBooks() throws RemoteException {
		
		return LivreDb.getBooks();
	}

	@Override
	public void AddBook(Livre livre) throws RemoteException {
		LivreDb.inserBook(livre);
		
	}

	@Override
	public void deleteBook(int isbn) throws RemoteException {
		LivreDb.deleteBook(isbn);
		
	}

	@Override
	public void Emprunter(Livre v, User u, String date) throws RemoteException {
	LivreDb.emprunter(v, u, date);	
	}

	@Override
	public User findUserById(String id) throws RemoteException {
		
		return UserDb.findUserById(id);
	}

	@Override
	public void inserUser(User u) throws RemoteException {
		UserDb.inserUser(u);
		
	}

	@Override
	public void deleteUser(String id) throws RemoteException {
		UserDb.deleteUser(id);
		
	}

	@Override
	public Livre findBookById(int isbn) {
		return LivreDb.findBookById(isbn);
	}

	@Override
	public ArrayList<LivresEmpunteeByUsers> getLivresEmpruntee() {
		return LivreDb.getLivresEmpruntee();
	}

	@Override
	public ArrayList<Livre> filterByAuthor(String auteur) {
		// TODO Auto-generated method stub
		return LivreDb.filterByAuthor(auteur);
	}

	@Override
	public ArrayList<Livre> filterByEditeur(String editeur) {
		// TODO Auto-generated method stub
		return LivreDb.filterByEditeur(editeur);
	}

	@Override
	public ArrayList<Livre> filterByTitle(String title) {
		// TODO Auto-generated method stub
		return LivreDb.filterByTitle(title);
	}

	@Override
	public ArrayList<User> filterByCategory(String category) {
		// TODO Auto-generated method stub
		return UserDb.filterByCategory(category);
	}

	@Override
	public ArrayList<User> filterByAdress(String address) {
		// TODO Auto-generated method stub
		return UserDb.filterByAdress(address);
	}

	

}
