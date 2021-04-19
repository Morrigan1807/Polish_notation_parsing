package controller;

import model.database.AccountModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AdminControllerTest {

    private static final List<AccountModel> allAccounts = new ArrayList<>();

    @BeforeAll
    public static void createAllAccounts() {
        AccountModel firstAccount = new AccountModel();
        firstAccount.setLogin("login");
        firstAccount.setEntityName("name");

        AccountModel secondAccount = new AccountModel();
        secondAccount.setAccessLevel("admin");
        secondAccount.setPassword("admin");

        AccountModel thirdAccount = new AccountModel();
        thirdAccount.setLogin("login");
        thirdAccount.setPassword("password");

        allAccounts.add(firstAccount);
        allAccounts.add(secondAccount);
        allAccounts.add(thirdAccount);
    }

    @Test
    public void testSetAllAccounts() {
        AdminController adminController = new AdminController();
        adminController.setAllAccounts(allAccounts);

        assertEquals(allAccounts, adminController.getAllAccounts());
    }

    @Test
    public void testChangeAccountInfoInSelected() {
        AdminController adminController = new AdminController();
        adminController.setAllAccounts(allAccounts);

        AccountModel changedAccount = new AccountModel();
        changedAccount.setAccessLevel("notAdmin");
        changedAccount.setPassword("hello");

        adminController.changeAccountInfoInSelected(1, changedAccount);

        assertEquals(changedAccount, adminController.getAllAccounts().get(1));
    }

    @Test
    public void testAddNewAccount() {
        AdminController adminController = new AdminController();
        adminController.setAllAccounts(allAccounts);

        AccountModel accountForAdd = new AccountModel();
        accountForAdd.setLogin("world");
        accountForAdd.setPassword("hello");

        adminController.addNewAccount(accountForAdd);

        assertNotEquals(-1, adminController.getAllAccounts().indexOf(accountForAdd));
    }

    @Test
    public void testDeleteAccount() {
        AdminController adminController = new AdminController();
        adminController.setAllAccounts(allAccounts);

        AccountModel deletedAccount = adminController.deleteAccount(2);

        assertEquals(-1, adminController.getAllAccounts().indexOf(deletedAccount));
    }
}