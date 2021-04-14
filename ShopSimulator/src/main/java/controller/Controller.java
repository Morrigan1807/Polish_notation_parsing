package controller;

import repository.AccountRepository;

public class Controller {

    private String login;
    private String password;
    private AccountRepository accountRepository;

    public boolean checkAccount() {
        return accountRepository.selectAccountByLoginAndPassword(login, password) != null;
    }

    public void loginOnSite() {

    }

    public void printError() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
