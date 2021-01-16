package Models;

import java.io.Serializable;

public class CreatorRequest implements Serializable {
    private String id;
    private User user;
    private boolean accepted;

    public CreatorRequest(User user) {
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
