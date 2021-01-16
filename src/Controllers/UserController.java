package Controllers;

import Models.CreatorRequest;
import Models.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UserController extends UnicastRemoteObject implements IUserController {
    public UserController() throws RemoteException {
    }

    @Override
    public void requestToBeCreator(User user) {
        System.out.println("received request");
        CreatorRequest creatorRequest = new CreatorRequest(user);

        Database database = Database.getCurrentDatabase();
        database.insertObject("CreatorRequests", creatorRequest);
    }
}
