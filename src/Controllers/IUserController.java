package Controllers;

import Models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUserController extends Remote {
    void requestToBeCreator(User user) throws RemoteException;
}
