package controller;

import lombok.Getter;
import model.database.AccountModel;
import repository.AccountRepository;
import repository.sqldatabase.AccountRepositorySql;

import java.util.ArrayList;
import java.util.List;

public class AdminController {

    //TODO Add configuration ling
    private AccountRepository accountRepository = new AccountRepositorySql();
    @Getter
    private List<AccountModel> allAccounts = new ArrayList<>();

    public void setAllAccounts(List<AccountModel> allAccounts) {
        //TODO Add select query to DB and writing in allAccounts
        this.allAccounts = allAccounts;
    }

    public void changeAccountDataInSelected(int indexOfSelected, AccountModel newAccountData) {
        //TODO Add update query to DB
        accountRepository.updateAccount(allAccounts.get(indexOfSelected).getLogin(), newAccountData);
        allAccounts.set(indexOfSelected, newAccountData);
    }

    public void addNewAccount(AccountModel newAccount) {
        //TODO Add insert query to DB
        accountRepository.insertAccount(newAccount);
        allAccounts.add(newAccount);
    }

    public AccountModel deleteAccount(int indexOfAccountForDelete) {
        //TODO Add delete query to DB
        accountRepository.deleteAccount(allAccounts.get(indexOfAccountForDelete).getLogin());
        return allAccounts.remove(indexOfAccountForDelete);
    }
}
