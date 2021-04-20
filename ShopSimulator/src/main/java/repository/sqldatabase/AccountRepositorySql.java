package repository.sqldatabase;

import model.database.AccountModel;
import model.database.EntityDataModel;
import repository.AccountRepository;

import java.util.List;

public class AccountRepositorySql implements AccountRepository {

    @Override
    public void insertAccount(AccountModel account) {
        //TODO Add insert query to DB (for admin)
    }

    @Override
    public void updateAccount(String loginAccountForUpdate, AccountModel accountWithNewInfo) {
        //TODO Add update query to DB (for admin)
    }

    @Override
    public void deleteAccount(String loginAccountForDelete) {
        //TODO Add delete query to DB (for admin)
    }

    @Override
    public List<AccountModel> selectAllAccounts() {
        //TODO Add select query to DB (for admin view)
        return null;
    }

    @Override
    public AccountModel selectAccountByLoginAndPassword(String login, String password) {
        //TODO Add select query to DB (for sign in)
        return null;
    }

    @Override
    public List<EntityDataModel> selectAllEntityData() {
        //TODO Add select query to DB (for marketer view)
        return null;
    }

    @Override
    public List<EntityDataModel> selectAllEntityDataByName(String name) {
        //TODO Add select query to DB (for marketer search)
        return null;
    }
}
