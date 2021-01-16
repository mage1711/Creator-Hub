package Controllers;

import Models.Post;
import Models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IPostsController extends Remote {
    ArrayList<Post> getPosts(User user) throws RemoteException;
    ArrayList<Object> generateFeed(User user);
}
