package Models;

import Controllers.Database;

import java.util.ArrayList;

public class SubscribeState extends ViewerState implements Observer {
    private ArrayList<Chat> chats;

    public SubscribeState() {
        super();
    }

    public SubscribeState(ArrayList<Chat> chats, ArrayList<Creator> subscribed) {
        this.chats = chats;
    }

    public SubscribeState(String name, String country, String email, ArrayList<Chat> chats, ArrayList<Creator> subscribed) {
        super(name, country, email);
        this.chats = chats;
    }

    public SubscribeState(String id, String name, String country, String email, boolean banned, ArrayList<String> warnings, ArrayList<Chat> chats, ArrayList<Creator> subscribed) {
        super(id, name, country, email, banned, warnings);
        this.chats = chats;
    }

    public ArrayList<Chat> getChats() {
        return chats;
    }

    public void setChats(ArrayList<Chat> chats) {
        this.chats = chats;
    }

    public void startChat(Creator creator) {
        Chat chat = new Chat(creator, this, new ArrayList<>(), new ArrayList<>());
        this.chats.add(chat);
//        creator.addChat(chat);
        Database database = Database.getCurrentDatabase();
        database.updateObject("Users", this, "id", this.getId());
    }

    public void unsubscribe(Creator creator) {
        this.subscribed.remove(creator);

        Database database = Database.getCurrentDatabase();
        database.updateObject("Users", this, "id", this.getId());
    }

    @Override
    public void update(String type) {
        if(type == "Subscriber")
        System.out.println("A new message is sent from creator");
    }
}
