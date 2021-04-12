package repository;

import model.database.AccountModel;
import model.database.EntityDataModel;

import java.util.List;

public interface AccountRepository {

    void insertAccount(AccountModel account);

    void updateAccount(String loginAccountForUpdate, AccountModel accountWithNewInfo);

    void deleteAccount(String loginAccountForDelete);

    List<AccountModel> selectAllAccounts();

    AccountModel selectAccountByLoginAndPassword(String login, String password);

    List<EntityDataModel> selectAllEntityData();

    List<EntityDataModel> selectAllEntityDataByName(String name);
}
