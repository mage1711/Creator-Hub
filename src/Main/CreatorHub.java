

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

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("authorizationController", authorizationController);
        registry.bind("postsController", postsController);
        registry.bind("moderatorController", moderatorController);
        registry.bind("userController", userController);
        System.out.println("ready!");
        Chat chat = new Chat(new Creator(),new SubscribeState(),new ArrayList<>(),new ArrayList<>());
        ChatMessage message = new ChatMessage("Hello",new Date(),chat.getSubscriber().getId(),chat.getCreator().getId());
        ChatController chatController = new ChatController();
        chatController.createChat(chat);
        chatController.sendMessage(chat,message);
    }
}
