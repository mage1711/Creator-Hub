package Main;

import Controllers.*;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CreatorHub {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        IAuthorization authorizationController = new AuthorizationController();
        IPostsController postsController = new PostsController();
        IModerator moderatorController = new ModeratorController();

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("authorizationController", authorizationController);
        registry.bind("postsController", postsController);
        registry.bind("moderatorController", moderatorController);
        System.out.println("ready!");
    }
}
