package repository.sqldatabase;

import model.database.AccountModel;
import model.database.EntityDataModel;
import repository.AccountRepository;

import java.util.List;

public class AccountRepositorySql implements AccountRepository {

    @Override
    public void insertAccount(AccountModel account) {

    }

    @Override
    public void updateAccount(String loginAccountForUpdate, AccountModel accountWithNewInfo) {

    }

    @Override
    public void deleteAccount(String loginAccountForDelete) {

    }

    @Override
    public List<AccountModel> selectAllAccounts() {
        return null;
    }

    @Override
    public AccountModel selectAccountByLoginAndPassword(String login, String password) {
        return null;
    }

    @Override
    public List<EntityDataModel> selectAllEntityData() {
        return null;
    }

    @Override
    public List<EntityDataModel> selectAllEntityDataByName(String name) {
        return null;
    }
}
