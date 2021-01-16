package Controllers;

import Models.Creator;
import Models.Post;
import Models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IPostsController extends Remote {
    ArrayList<Post> getPosts(User user) throws RemoteException;
    public void CreatePost(Creator creator,Post post)  throws RemoteException;
    public Post GetPost(User user)  throws RemoteException;
}
