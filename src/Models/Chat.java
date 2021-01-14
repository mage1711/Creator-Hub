package Models;

import java.util.ArrayList;

public class Chat implements Subject {
    private Creator creator;
    private User subscriber;
    private ArrayList<ChatMessage> messages;
    private ArrayList<Observer> observers;

    public Chat() {
    }

    public Chat(Creator creator, User subscriber, ArrayList<ChatMessage> messages, ArrayList<Observer> observers) {
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

    public User getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(User subscriber) {
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

    public void addMessage(ChatMessage message) {
        messages.add(message);
        notifyObservers();
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
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
