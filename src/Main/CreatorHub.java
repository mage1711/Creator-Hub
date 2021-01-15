package Main;

import Controllers.AuthorizationController;
import Controllers.Database;
import Controllers.IAuthorization;
import Models.User;
import com.google.gson.Gson;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CreatorHub {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        IAuthorization authorizationController = new AuthorizationController();

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("authorizationController", authorizationController);
        System.out.println("ready!");
    }
}
