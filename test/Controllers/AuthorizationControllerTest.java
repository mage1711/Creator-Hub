package Controllers;

import Models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizationControllerTest {
    private final Database database = new Database();

    @Test
    void login() {
        // Prepare
        String inputEmail = "test@test.com";
        String inputPassword = "123123";
        AuthorizationController.signup(inputEmail, "Test", inputPassword, "Egypt");
        AuthorizationController.currentUser = null;

        // Test
        AuthorizationController.login(inputEmail, inputPassword);
        assertEquals(inputEmail, AuthorizationController.currentUser.getEmail());

        // Clean
        AuthorizationController.currentUser = null;
        this.database.deleteObject("Users", null, "email", inputEmail);
    }

    @Test
    void logout() {
        // Prepare
        String inputEmail = "test@test.com";
        String inputPassword = "123123";
        AuthorizationController.signup(inputEmail, "Test", inputPassword, "Egypt");
        AuthorizationController.currentUser = null;

        // Test
        AuthorizationController.logout();
        assertNull(AuthorizationController.currentUser);

        // Clean
        this.database.deleteObject("Users", null, "email", inputEmail);
    }

    @Test
    void signup() {
        String inputEmail = "test@test.com";
        String inputPassword = "123123";
        AuthorizationController.signup(inputEmail, "Test", inputPassword, "Egypt");
        assertEquals(inputEmail, AuthorizationController.currentUser.getEmail());

        // Clean
        AuthorizationController.currentUser = null;
        this.database.deleteObject("Users", null, "email", inputEmail);
    }
}