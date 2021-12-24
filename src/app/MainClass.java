package app;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import beans.Livre;
import beans.User;
import db.LivreDb;
import db.UserDb;

public class MainClass {
    public static void main(String[] args) {
      /*  try {
            LocateRegistry.createRegistry(1099);
            ServiceImp sr= new ServiceImp();
            System.out.println(sr.toString());
            Naming.rebind("rmi://localhost:1099/BK",sr);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
    	Livre l= LivreDb.findBookById(1111);
    	User u= UserDb.findUserById("PB23465");
    	LivreDb.emprunter(l, u, "2022-11-11");
    }
}
