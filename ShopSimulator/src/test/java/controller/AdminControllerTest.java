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
    private static final AdminController adminController = new AdminController();

    @BeforeAll
    public static void createAllAccounts() {
        allAccounts.add(AccountModel.builder().login("login").entityName("name").build());
        allAccounts.add(AccountModel.builder().accessLevel("admin").password("admin").build());
        allAccounts.add(AccountModel.builder().login("login").password("password").build());

        adminController.setAllAccounts(allAccounts);
    }

    @Test
    public void testSetAllAccounts() {
        assertEquals(allAccounts, adminController.getAllAccounts());
    }

    @Test
    public void testChangeAccountInfoInSelected() {
        AccountModel changedAccount = AccountModel.builder()
                .accessLevel("notAdmin")
                .password("hello")
                .build();
        adminController.changeAccountInfoInSelected(1, changedAccount);

        assertEquals(changedAccount, adminController.getAllAccounts().get(1));
    }

    @Test
    public void testAddNewAccount() {
        AccountModel accountForAdd = AccountModel.builder()
                .login("world")
                .password("hello")
                .build();
        adminController.addNewAccount(accountForAdd);

        assertNotEquals(-1, adminController.getAllAccounts().indexOf(accountForAdd));
    }

    @Test
    public void testDeleteAccount() {
        AccountModel deletedAccount = adminController.deleteAccount(2);

        assertEquals(-1, adminController.getAllAccounts().indexOf(deletedAccount));
    }
}