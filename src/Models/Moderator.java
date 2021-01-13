package Models;

import java.util.ArrayList;

public class Moderator {
    private String id;
    private String name;
    private String email;

    public Moderator(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void acceptCreator(User user) {}

    public ArrayList<Report> getReports() {
        return new ArrayList<>();
    }

    public void deletePost(Post post) {}

    public void banUser(User user) {}

    public void warnUser(User user) {}

    public ArrayList<CreatorRequest> getCreatorRequests() {
        return new ArrayList<>();
    }
}
