package controller;

import model.database.AccountModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private static final Controller controller = new Controller();

    @BeforeAll
    public static void createController() {
        controller.setLogin("login");
        controller.setPassword("password");
    }

    @Test
    public void testCheckAccountCorrectCase() {
        controller.setCurrentAccount(AccountModel.builder().build());
        assertTrue(controller.checkAccount());
    }

    @Test
    public void testCheckAccountIncorrectCase() {
        assertFalse(controller.checkAccount());
    }

    @Test
    public void testLoginOnSiteAdminCase() {
        controller.setCurrentAccount(AccountModel.builder().accessLevel("admin").build());
        assertEquals("Going to admin page.", controller.loginOnSite());
    }

    @Test
    public void testLoginOnSiteMarketerCase() {
        controller.setCurrentAccount(AccountModel.builder().accessLevel("marketer").build());
        assertEquals("Going to marketer page.", controller.loginOnSite());
    }

    @Test
    public void testLoginOnSiteClientCase() {
        controller.setCurrentAccount(AccountModel.builder().accessLevel("client").build());
        assertEquals("Going to client page.", controller.loginOnSite());
    }
}