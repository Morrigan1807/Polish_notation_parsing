package model.database;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountModel {

    private String login;
    private String password;
    private String accessLevel;
    private String entityName;
    private String entityPhoneNumber;
}
