package Models;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

public class Chat implements Subject, Serializable {


    private String id;
    private Creator creator;
    private SubscribeState subscriber;
    private ArrayList<ChatMessage> messages;
    private ArrayList<Observer> observers;

    public Chat() {
    }

    public Chat(Creator creator, SubscribeState subscriber, ArrayList<ChatMessage> messages, ArrayList<Observer> observers) {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        this.id = generatedString;
        this.creator = creator;
        this.subscriber = subscriber;
        this.messages = messages;
        this.observers = observers;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public SubscribeState getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(SubscribeState subscriber) {
        this.subscriber = subscriber;
    }

    public ArrayList<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<ChatMessage> messages) {
        this.messages = messages;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addMessage(ChatMessage message) {
        messages.add(message);
        if(message.getReceiverID() == creator.getId())
        notifyObservers("Creator");
        else notifyObservers("Subscriber");
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String type) {
        for (Observer observer : observers) {
            observer.update(type);
        }
    }
}
