package Controllers;

import Models.User;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizationControllerTest {
    private final Database database = Database.getCurrentDatabase();
    private AuthorizationController authorizationController;

    AuthorizationControllerTest() {
        try {
            authorizationController = new AuthorizationController();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Test
    void login() {
        // Prepare
        String inputEmail = "test@test.test";
        String inputPassword = "123123";
        authorizationController.signup(inputEmail, "Test", inputPassword, "Egypt");
        AuthorizationController.currentUser = null;

        // Test
        authorizationController.login(inputEmail, inputPassword);
        assertEquals(inputEmail, AuthorizationController.currentUser.getEmail());

        // Clean
        AuthorizationController.currentUser = null;
        this.database.deleteObject("Users", null, "email", inputEmail);
    }

    @Test
    void logout() {
        // Prepare
        String inputEmail = "test@test.test";
        String inputPassword = "123123";
        authorizationController.signup(inputEmail, "Test", inputPassword, "Egypt");
        AuthorizationController.currentUser = null;

        // Test
        authorizationController.logout();
        assertNull(AuthorizationController.currentUser);

        // Clean
        this.database.deleteObject("Users", null, "email", inputEmail);
    }

    @Test
    void signup() {
        String inputEmail = "test@test.test";
        String inputPassword = "123123";
        authorizationController.signup(inputEmail, "Test", inputPassword, "Egypt");
        assertEquals(inputEmail, AuthorizationController.currentUser.getEmail());

        // Clean
        AuthorizationController.currentUser = null;
        this.database.deleteObject("Users", null, "email", inputEmail);
    }
}