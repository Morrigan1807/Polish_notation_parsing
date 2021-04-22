package controller;

import model.database.AccountModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdminControllerTest {

    private final List<AccountModel> allAccounts = new ArrayList<>();
    private final AdminController adminController = new AdminController();

    @BeforeEach
    public void createAllAccounts() {
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
    public void testSetAllAccountsDoesNotThrow() {
        assertDoesNotThrow(adminController::getAllAccounts);
    }

    @Test
    public void testSetAllAccountsNotNullCheckCase() {
        assertNotNull(adminController.getAllAccounts());
    }

    @Test
    public void testChangeAccountInfoInSelected() {
        AccountModel changedAccount = AccountModel.builder()
                .accessLevel("notAdmin")
                .password("hello")
                .build();
        adminController.changeAccountDataInSelected(1, changedAccount);

        assertEquals(changedAccount, adminController.getAllAccounts().get(1));
    }

    @Test
    public void testChangeAccountInfoInSelectedDoesNotThrow() {
        AccountModel changedAccount = AccountModel.builder()
                .accessLevel("notAdmin")
                .password("hello")
                .build();

        assertDoesNotThrow(() -> adminController.changeAccountDataInSelected(1, changedAccount));
    }

    @Test
    public void testAddNewAccount() {
        AccountModel accountForAdd = AccountModel.builder()
                .login("login")
                .password("password")
                .accessLevel("client")
                .entityName("Alex Smith")
                .entityPhoneNumber("+375335558800")
                .build();
        adminController.addNewAccount(accountForAdd);

        assertNotEquals(-1, adminController.getAllAccounts().indexOf(accountForAdd));
    }

    @Test
    public void testAddNewAccountDoesNotThrow() {
        AccountModel accountForAdd = AccountModel.builder()
                .login("login")
                .password("password")
                .accessLevel("client")
                .entityName("Alex Smith")
                .entityPhoneNumber("+375335558800")
                .build();

        assertDoesNotThrow(() -> adminController.addNewAccount(accountForAdd));
    }

    @Test
    public void testDeleteAccount() {
        AccountModel deletedAccount = adminController.deleteAccount(2);

        assertEquals(-1, adminController.getAllAccounts().indexOf(deletedAccount));
    }

    @Test
    public void testDeleteAccountDoesNotThrow() {
        assertDoesNotThrow(() -> adminController.deleteAccount(2));
    }
}