package Models;

import java.util.ArrayList;

public class SubscribeState extends ViewerState {
    private ArrayList<Chat> chats;
    private ArrayList<Creator> subscribed;

    public SubscribeState() {
    }

    public SubscribeState(ArrayList<Chat> chats, ArrayList<Creator> subscribed) {
        this.chats = chats;
        this.subscribed = subscribed;
    }

    public SubscribeState(String name, String country, String email, ArrayList<Chat> chats, ArrayList<Creator> subscribed) {
        super(name, country, email);
        this.chats = chats;
        this.subscribed = subscribed;
    }

    public SubscribeState(String id, String name, String country, String email, boolean banned, ArrayList<String> warnings, ArrayList<Chat> chats, ArrayList<Creator> subscribed) {
        super(id, name, country, email, banned, warnings);
        this.chats = chats;
        this.subscribed = subscribed;
    }

    public ArrayList<Chat> getChats() {
        return chats;
    }

    public void setChats(ArrayList<Chat> chats) {
        this.chats = chats;
    }

    public ArrayList<Creator> getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(ArrayList<Creator> subscribed) {
        this.subscribed = subscribed;
    }

    public void chat(Creator creator) {}

    public void unsubscribe(Creator creator) {}
}
