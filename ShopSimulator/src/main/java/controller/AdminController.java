package controller;

import model.database.AccountModel;
import repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

public class AdminController {

    private AccountRepository accountRepository;
    private List<AccountModel> allAccounts = new ArrayList<>();

    public void setAllAccounts() {
        allAccounts = accountRepository.selectAllAccounts();
    }

    public void changeAccountInfoInSelected(int indexOfSelected, AccountModel newAccountData) {
        accountRepository.updateAccount(allAccounts.get(indexOfSelected).getLogin(), newAccountData);
        allAccounts.set(indexOfSelected, newAccountData);
    }

    public void addNewAccount(AccountModel newAccount) {
        accountRepository.insertAccount(newAccount);
        allAccounts.add(newAccount);
    }

    public void deleteAccount(int indexOfAccountForDelete) {
        accountRepository.deleteAccount(allAccounts.get(indexOfAccountForDelete).getLogin());
        allAccounts.remove(indexOfAccountForDelete);
    }
}
