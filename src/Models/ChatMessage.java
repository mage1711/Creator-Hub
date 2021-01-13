package Models;

import java.util.Date;

public class ChatMessage {
    private String text;
    private Date time;
    private User sender;

    public ChatMessage() {
    }

    public ChatMessage(String text, Date time, User sender) {
        this.text = text;
        this.time = time;
        this.sender = sender;
    }
}
