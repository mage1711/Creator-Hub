package Models;

import Controllers.Database;

import java.util.ArrayList;

public class ViewerState extends User {
    protected ArrayList<Creator> followedCreators;
    protected ArrayList<Creator> subscribed;

    public ViewerState() {
    }

    public ViewerState(String name, String country, String email) {
        super(name, country, email);
    }

    public ViewerState(String id, String name, String country, String email, boolean banned, ArrayList<String> warnings) {
        super(id, name, country, email, banned, warnings);
    }

    public void becomeCreator() {
         CreatorRequest creatorRequest = new CreatorRequest(this);

        Database database = Database.getCurrentDatabase();
        database.insertObject("CreatorRequests", creatorRequest);
    }

    public void reportCreator(Creator creator, String reportText) {
        Report report = new Report(null, this, creator, reportText);

        Database database = Database.getCurrentDatabase();
        database.insertObject("Reports", report);
    }

    public ArrayList<Creator> getFollowedCreators() {
        return followedCreators;
    }

    public void setFollowedCreators(ArrayList<Creator> followedCreators) {
        this.followedCreators = followedCreators;
    }

    public ArrayList<Creator> getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(ArrayList<Creator> subscribed) {
        this.subscribed = subscribed;
    }
}
