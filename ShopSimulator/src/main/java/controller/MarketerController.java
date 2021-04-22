package controller;

import lombok.Getter;
import model.database.EntityDataModel;
import repository.AccountRepository;
import repository.sqldatabase.AccountRepositorySql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarketerController {

    //TODO Add configuration ling
    private final AccountRepository accountRepository = new AccountRepositorySql();
    @Getter
    private List<EntityDataModel> allEntities = new ArrayList<>();

    public void setAllEntities(List<EntityDataModel> allEntities) {
        //TODO Add select query to DB and writing in allEntities
        this.allEntities = allEntities;
    }

    public List<EntityDataModel> getAllEntityByName(String name) {
        //TODO Add select query to DB (by name) and writing in allEntitiesByName
        List<EntityDataModel> allEntitiesByName = new ArrayList<>();

        for (EntityDataModel entity : allEntities) {
            if (entity.getEntityName().equals(name)) {
                allEntitiesByName.add(entity);
            }
        }

        return allEntitiesByName;
    }

    public List<List<String>> generateReportAboutAllSimulations() {
        //TODO Add creating excel-file for report
        List<List<String>> reportData = new ArrayList<>();

        for (EntityDataModel entityData : allEntities) {
            reportData.add(Arrays.asList(entityData.getEntityName(),
                    entityData.getPhoneNumber(),
                    entityData.getSimulationsCount().toString()));
        }

        return reportData;
    }
}
