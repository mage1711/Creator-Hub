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

    public void acceptCreator(User user) {
        Creator creator = (Creator) user;
        // TODO: Add to database
    }

    public ArrayList<Report> getReports() {
        // TODO: Retrieve from database
        return new ArrayList<>();
    }

    public void deletePost(Post post) {
        // TODO: Delete from database
    }

    public void banUser(User user) {
        user.setBanned(true);
        // TODO: Update in database
    }

    public void warnUser(User user, String warningText) {
        user.addWarning(warningText);
        // TODO: Update in database
    }

    public ArrayList<CreatorRequest> getCreatorRequests() {
        // TODO: Get from database
        return new ArrayList<>();
    }
}
