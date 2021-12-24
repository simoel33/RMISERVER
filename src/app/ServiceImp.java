package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import beans.Livre;
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

}
