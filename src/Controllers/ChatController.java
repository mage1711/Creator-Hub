package Controllers;

import Models.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatController extends UnicastRemoteObject implements IChatController {
    public ChatController() throws RemoteException {
    }

    @Override
    public void createChat(Chat chat) throws RemoteException {
        Database db = Database.getCurrentDatabase();
        db.insertObject("Chats", chat);
    }

    @Override
    public Chat sendMessage(Chat chat, ChatMessage message) throws RemoteException {
        Database db = Database.getCurrentDatabase();
        chat.registerObserver(chat.getCreator());
        chat.registerObserver(chat.getSubscriber());
        chat.addMessage(message);
        chat.setObservers(new ArrayList<>());
        db.updateObject("Chats", chat, "id", chat.getId());
        System.out.println(chat.getMessages().get(0).getText());
        return chat;
    }

    @Override
    public ArrayList<Chat> getChats(String userID) throws RemoteException {
        System.out.println("Here!!!!!!!!!!!!!!!!!!!!!!" + userID);
        Database database = Database.getCurrentDatabase();
        ArrayList<Chat> chats = new ArrayList<>();
        ArrayList<Object> chatsDocs = database.getAllDocuments("Chats", Chat.class);
        try {
            for (Object chatDoc : chatsDocs) {
                Chat chat = (Chat) chatDoc;
                if ((chat.getCreator().getEmail() != null && chat.getCreator().getEmail().equals(userID)) || (chat.getSubscriber().getEmail() != null && chat.getSubscriber().getEmail().equals(userID)))
                    System.out.println(true);
                chats.add(chat);
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return chats;
    }


}
