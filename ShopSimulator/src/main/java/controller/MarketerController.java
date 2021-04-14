package controller;

import model.database.EntityDataModel;
import repository.AccountRepository;
import repository.SimulationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarketerController {

    private SimulationRepository simulationRepository;
    private AccountRepository accountRepository;
    private List<EntityDataModel> allEntities = new ArrayList<>();

    public void setAllEntities() {
        allEntities = accountRepository.selectAllEntityData();
    }

    public List<EntityDataModel> getAllEntityByName(String name) {
        return accountRepository.selectAllEntityDataByName(name);
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
