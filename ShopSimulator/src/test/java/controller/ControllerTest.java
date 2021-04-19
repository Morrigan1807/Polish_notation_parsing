package controller;

import model.database.AccountModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private static Controller controller = new Controller();

    @BeforeAll
    public static void createController() {
        controller.setLogin("login");
        controller.setPassword("password");
    }

    @Test
    public void testCheckAccountCorrectCase() {
        controller.setCurrentAccount(new AccountModel());
        assertTrue(controller.checkAccount());
    }

    @Test
    public void testCheckAccountIncorrectCase() {
        assertFalse(controller.checkAccount());
    }

    @Test
    public void testLoginOnSiteAdminCase() {
        AccountModel account = new AccountModel();
        account.setAccessLevel("admin");
        controller.setCurrentAccount(account);

        assertEquals("Going to admin page.", controller.loginOnSite());
    }

    @Test
    public void testLoginOnSiteMarketerCase() {
        AccountModel account = new AccountModel();
        account.setAccessLevel("marketer");
        controller.setCurrentAccount(account);

        assertEquals("Going to marketer page.", controller.loginOnSite());
    }

    @Test
    public void testLoginOnSiteClientCase() {
        AccountModel account = new AccountModel();
        account.setAccessLevel("client");
        controller.setCurrentAccount(account);

        assertEquals("Going to client page.", controller.loginOnSite());
    }
}