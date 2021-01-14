package Controllers;

import Models.User;

public class AuthorizationController {
    public static User currentUser;

    public AuthorizationController() {
    }

    public static User login(String email, String password) {
        Database database = new Database();
        User user = (User) database.getDocument("Users", "email", email, User.class);
        if (user.getPassword().equals(password)) {
            currentUser = user;
            return user;
        }
        return null;
    }

    public static void logout() {
        currentUser = null;
    }

    public static User signup(String email, String name, String password, String country) {
        User user = new User(name, country, email, password);
        Database database = new Database();
        database.insertObject("Users", user);
        user = (User) database.getDocument("Users", "email", email, User.class);
        currentUser = user;
        return user;
    }
}
