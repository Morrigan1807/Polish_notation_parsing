package controller;

import lombok.Getter;
import model.database.AccountModel;
import repository.AccountRepository;
import repository.sqldatabase.AccountRepositorySql;

import java.util.ArrayList;
import java.util.List;

public class AdminController {

    private AccountRepository accountRepository = new AccountRepositorySql();
    @Getter
    private List<AccountModel> allAccounts = new ArrayList<>();

    public void setAllAccounts(List<AccountModel> allAccounts) {
        this.allAccounts = allAccounts;
    }

    public void changeAccountInfoInSelected(int indexOfSelected, AccountModel newAccountData) {
        accountRepository.updateAccount(allAccounts.get(indexOfSelected).getLogin(), newAccountData);
        allAccounts.set(indexOfSelected, newAccountData);
    }

    public void addNewAccount(AccountModel newAccount) {
        accountRepository.insertAccount(newAccount);
        allAccounts.add(newAccount);
    }

    public AccountModel deleteAccount(int indexOfAccountForDelete) {
        accountRepository.deleteAccount(allAccounts.get(indexOfAccountForDelete).getLogin());
        return allAccounts.remove(indexOfAccountForDelete);
    }
}
