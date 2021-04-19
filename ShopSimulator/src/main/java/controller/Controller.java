package controller;

import lombok.Getter;
import lombok.Setter;
import model.database.AccountModel;
import repository.AccountRepository;
import repository.sqldatabase.AccountRepositorySql;

public class Controller {

    @Getter
    @Setter
    private String login;
    @Getter
    @Setter
    private String password;
    @Setter
    private AccountModel currentAccount;
    private AccountRepository accountRepository = new AccountRepositorySql();

    public boolean checkAccount() {
        return currentAccount != null;
    }

    public String loginOnSite() {
        //currentAccount = accountRepository.selectAccountByLoginAndPassword(login, password);

        if (checkAccount()) {
            switch (currentAccount.getAccessLevel()) {
                case "client":
                    return "Going to client page.";
                case "marketer":
                    return "Going to marketer page.";
                case "admin":
                    return "Going to admin page.";
                default:
                    return "Error! You don't have any access.";
            }
        }
        return "Error! Wrong login or password.";
    }
}
