package model.database;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntityDataModel {

    private String entityName;
    private String phoneNumber;
    private Integer simulationsCount;
}
