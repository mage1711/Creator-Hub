package Controllers;

import Models.CreatorRequest;
import Models.Post;
import Models.Report;
import Models.User;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IModerator extends Remote {
    ArrayList<CreatorRequest> getCreatorRequests() throws RemoteException;
    ArrayList<Report> getReports() throws RemoteException;
    public void acceptCreator(User user) throws RemoteException;
    public void deletePost(Post post) throws RemoteException;
    public void banUser(User user) throws RemoteException;
    public void warnUser(User user, String warningText) throws RemoteException;


}
