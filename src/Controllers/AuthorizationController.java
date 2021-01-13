package Controllers;

import Models.User;

public class AuthorizationController {
    private User currentUser;

    public AuthorizationController() {
    }

    public AuthorizationController(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User login(String email, String password) {
        return null;
    }

    public void logout() {

    }

    public User signup(String email, String name, String password, String country) {
        return null;
    }
}
