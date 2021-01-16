package Controllers;

import Models.Chat;
import Models.ChatMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IChatController extends Remote {
    void createChat(Chat chat) throws RemoteException;
    Chat sendMessage(Chat chat,ChatMessage message) throws RemoteException;
    ArrayList<Chat> getChats(String userID) throws RemoteException;

}
