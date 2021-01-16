package Main;

import Controllers.*;
import Models.*;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Date;

public class CreatorHub {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        IAuthorization authorizationController = new AuthorizationController();
        IPostsController postsController = new PostsController();
        IModerator moderatorController = new ModeratorController();
        IUserController userController = new UserController();
        IChatController chatController = new ChatController();

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("authorizationController", authorizationController);
        registry.bind("postsController", postsController);
        registry.bind("moderatorController", moderatorController);
        registry.bind("userController", userController);
        registry.bind("chatController", chatController);
        System.out.println("ready!");
    }
}
