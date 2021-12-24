package app;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import beans.Livre;
import beans.User;

public interface IBiblio extends Remote {
	
	//les méthodes de Livre
    public  ArrayList<Livre> getBooks() throws RemoteException;
    public  void AddBook(Livre livre) throws RemoteException;
    public void deleteBook(int isbn) throws  RemoteException;
    public void Emprunter(Livre v,User u,String date) throws  RemoteException;
    public Livre findBookById(int isbn) throws  RemoteException;
    public ArrayList<Livre> getLivresEmpruntee() throws  RemoteException;
    
    
    //les méthodes de user
    public User findUserById(String id) throws RemoteException;
    public void inserUser(User u) throws RemoteException;
    public void deleteUser(String id) throws RemoteException;

}