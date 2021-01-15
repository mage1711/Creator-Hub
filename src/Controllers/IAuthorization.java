package Controllers;

import Models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAuthorization extends Remote {
    User login(String email, String password) throws RemoteException;

    void logout() throws RemoteException;

    User signup(String email, String name, String password, String country) throws RemoteException;
}
