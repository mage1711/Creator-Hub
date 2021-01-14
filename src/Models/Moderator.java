package Models;

import Controllers.Database;

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
        Database database = new Database();
        database.updateObject("Users", creator, "id", creator.getId());
    }

    public ArrayList<Report> getReports() {
        Database database = new Database();
        ArrayList<Report> reports = new ArrayList<>();
        ArrayList<Object> reportsDocs = database.getAllDocuments("Reports", Report.class);
        for (Object reportsDoc : reportsDocs) {
            reports.add((Report) reportsDoc);
        }
        return reports;
    }

    public void deletePost(Post post) {
        Database database = new Database();
        database.deleteObject("Posts", post, "id", post.getId());
    }

    public void banUser(User user) {
        user.setBanned(true);
        Database database = new Database();
        database.updateObject("Users", user, "id", user.getId());
    }

    public void warnUser(User user, String warningText) {
        user.addWarning(warningText);
        Database database = new Database();
        database.updateObject("Users", user, "id", user.getId());
    }

    public ArrayList<CreatorRequest> getCreatorRequests() {
        Database database = new Database();
        ArrayList<CreatorRequest> requests = new ArrayList<>();
        ArrayList<Object> requestsDocs = database.getAllDocuments("CreatorRequests", Report.class);
        for (Object requestDoc : requestsDocs) {
            requests.add((CreatorRequest) requestDoc);
        }
        return requests;
    }
}
