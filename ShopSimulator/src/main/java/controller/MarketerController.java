package controller;

import lombok.Getter;
import model.database.EntityDataModel;
import repository.AccountRepository;
import repository.sqldatabase.AccountRepositorySql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarketerController {

    private AccountRepository accountRepository = new AccountRepositorySql();
    @Getter
    private List<EntityDataModel> allEntities = new ArrayList<>();

    public void setAllEntities(List<EntityDataModel> allEntities) {
        this.allEntities = allEntities;
    }

    public List<EntityDataModel> getAllEntityByName(String name) {
        List<EntityDataModel> allEntityByName = new ArrayList<>();

        for (EntityDataModel entity : allEntities) {
            if (entity.getEntityName().equals(name)) {
                allEntityByName.add(entity);
            }
        }

        return allEntityByName;
    }

    public List<List<String>> generateReportAboutAllSimulations() {
        List<List<String>> reportData = new ArrayList<>();

        for (EntityDataModel entityData : allEntities) {
            reportData.add(Arrays.asList(entityData.getEntityName(),
                    entityData.getPhone_number(),
                    entityData.getSimulationsCount().toString()));
        }

        return reportData;
    }
}
