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
    //TODO Add configuration ling
    private AccountRepository accountRepository = new AccountRepositorySql();

    public boolean checkAccount() {
        return currentAccount != null;
    }

    public String loginOnSite() {
        //TODO Add select query to DB (with login + password)
        if (checkAccount()) {
            switch (currentAccount.getAccessLevel()) {
                case "client":
                    //TODO Add jump to new page with client controller
                    return "Going to client page.";
                case "marketer":
                    //TODO Add jump to new page with marketer controller
                    return "Going to marketer page.";
                case "admin":
                    //TODO Add jump to new page with admin controller
                    return "Going to admin page.";
                default:
                    //TODO Add alert with information
                    return "Error! You don't have any access.";
            }
        }
        //TODO Add alert with information
        return "Error! Wrong login or password.";
    }
}
