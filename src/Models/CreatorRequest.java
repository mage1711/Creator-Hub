package Models;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Random;

public class CreatorRequest implements Serializable {
    private String id;
    private User user;
    private boolean accepted;

    public CreatorRequest(User user) {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        this.id = generatedString;
        this.user = user;
    }

    public CreatorRequest(String id, User user) {
        this.id = id;
        this.user = user;
    }

    public CreatorRequest(String id, User user, boolean accepted) {
        this.id = id;
        this.user = user;
        this.accepted = accepted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
