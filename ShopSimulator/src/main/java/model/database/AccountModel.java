package model.database;

import lombok.Data;

@Data
public class AccountModel {

    private String login;
    private String password;
    private String accessLevel;
    private String entityName;
    private String entityPhoneNumber;
}
