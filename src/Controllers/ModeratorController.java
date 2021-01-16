package Controllers;

import Models.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ModeratorController extends UnicastRemoteObject implements IModerator{
    public ModeratorController() throws RemoteException {
    }

    @Override
    public void acceptCreator(User user) {
        Creator creator = (Creator) user;
        Database database = Database.getCurrentDatabase();
        database.updateObject("Users", creator, "id", creator.getId());
    }

    @Override
    public ArrayList<Report> getReports() {
        Database database = Database.getCurrentDatabase();
        ArrayList<Report> reports = new ArrayList<>();
        ArrayList<Object> reportsDocs = database.getAllDocuments("Reports", Report.class);
        for (Object reportsDoc : reportsDocs) {
            reports.add((Report) reportsDoc);
        }
        return reports;
    }

    @Override
    public void deletePost(Post post) {
        Database database = Database.getCurrentDatabase();
        database.deleteObject("Posts", post, "id", post.getId());
    }

    @Override
    public void banUser(User user) {
        user.setBanned(true);
        Database database = Database.getCurrentDatabase();
        database.updateObject("Users", user, "id", user.getId());
    }

    @Override
    public void warnUser(User user, String warningText) {
        user.addWarning(warningText);
        Database database = Database.getCurrentDatabase();
        database.updateObject("Users", user, "id", user.getId());
    }

    @Override
    public ArrayList<CreatorRequest> getCreatorRequests() {
        Database database = Database.getCurrentDatabase();
        ArrayList<CreatorRequest> requests = new ArrayList<>();
        ArrayList<Object> requestsDocs = database.getAllDocuments("CreatorRequests", Report.class);
        for (Object requestDoc : requestsDocs) {
            requests.add((CreatorRequest) requestDoc);
        }
        return requests;
    }
}
