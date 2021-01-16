package Models;

import java.io.Serializable;
import java.util.Date;

public class ChatMessage implements Serializable {
    private String text;
    private Date time;
    private String senderID;
    private String receiverID;
    public ChatMessage() {
    }

    public ChatMessage(String text, Date time, String senderID, String receiverID) {
        this.text = text;
        this.time = time;
        this.senderID = senderID;
        this.receiverID = receiverID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(String receiverID) {
        this.receiverID = receiverID;
    }
}
