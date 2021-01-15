package Controllers;

import Models.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AuthorizationController extends UnicastRemoteObject implements IAuthorization {
    public static User currentUser;

    public AuthorizationController() throws RemoteException {
    }

    @Override
    public User login(String email, String password) {
        Database database = Database.getCurrentDatabase();
        User user = (User) database.getDocument("Users", "email", email, User.class);
        if (user.getPassword().equals(password)) {
            currentUser = user;
            return user;
        }
        return null;
    }

    @Override
    public void logout() {
        currentUser = null;
    }

    @Override
    public User signup(String email, String name, String password, String country) {
        User user = new User(name, country, email, password);
        Database database = Database.getCurrentDatabase();
        database.insertObject("Users", user);
        user = (User) database.getDocument("Users", "email", email, User.class);
        currentUser = user;
        return user;
    }
}
