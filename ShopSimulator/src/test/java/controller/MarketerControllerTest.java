package controller;

import model.database.EntityDataModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarketerControllerTest {

    private static final List<EntityDataModel> allEntities = new ArrayList<>();

    @BeforeAll
    public static void createAllEntities() {
        EntityDataModel firstEntity = new EntityDataModel();
        firstEntity.setEntityName("Alex");
        firstEntity.setPhone_number("+375334445522");
        firstEntity.setSimulationsCount(10);

        EntityDataModel secondEntity = new EntityDataModel();
        secondEntity.setEntityName("John");
        secondEntity.setPhone_number("+375291112211");
        secondEntity.setSimulationsCount(16);

        EntityDataModel thirdEntity = new EntityDataModel();
        thirdEntity.setEntityName("Mary");
        thirdEntity.setPhone_number("+375448885577");
        thirdEntity.setSimulationsCount(12);

        allEntities.add(firstEntity);
        allEntities.add(secondEntity);
        allEntities.add(thirdEntity);
    }

    @Test
    public void testSetAllEntities() {
        MarketerController marketerController = new MarketerController();
        marketerController.setAllEntities(allEntities);

        assertEquals(allEntities, marketerController.getAllEntities());
    }

    @Test
    public void testGetAllEntityByName() {
        MarketerController marketerController = new MarketerController();
        marketerController.setAllEntities(allEntities);

        String searchedName = "Alex";
        List<EntityDataModel> allEntityByName = marketerController.getAllEntityByName(searchedName);

        for (EntityDataModel entity : allEntityByName) {
            assertEquals(searchedName, entity.getEntityName());
        }
    }

    @Test
    public void testGenerateReportAboutAllSimulations() {
        MarketerController marketerController = new MarketerController();
        marketerController.setAllEntities(allEntities);

        List<List<String>> expectedReportData = new ArrayList<>();

        for (EntityDataModel entityData : allEntities) {
            expectedReportData.add(Arrays.asList(entityData.getEntityName(),
                    entityData.getPhone_number(),
                    entityData.getSimulationsCount().toString()));
        }

        assertEquals(expectedReportData, marketerController.generateReportAboutAllSimulations());
    }
}