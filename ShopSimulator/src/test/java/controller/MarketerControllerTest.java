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
    private static final MarketerController marketerController = new MarketerController();

    @BeforeAll
    public static void createAllEntities() {
        allEntities.add(EntityDataModel.builder().entityName("Alex").phone_number("+375334445522").simulationsCount(10).build());
        allEntities.add(EntityDataModel.builder().entityName("John").phone_number("+375291112211").simulationsCount(16).build());
        allEntities.add(EntityDataModel.builder().entityName("Mary").phone_number("+375448885577").simulationsCount(12).build());
        marketerController.setAllEntities(allEntities);
    }

    @Test
    public void testSetAllEntities() {
        assertEquals(allEntities, marketerController.getAllEntities());
    }

    @Test
    public void testGetAllEntityByName() {
        String searchedName = "Alex";
        List<EntityDataModel> allEntityByName = marketerController.getAllEntityByName(searchedName);

        for (EntityDataModel entity : allEntityByName) {
            assertEquals(searchedName, entity.getEntityName());
        }
    }

    @Test
    public void testGenerateReportAboutAllSimulations() {
        List<List<String>> expectedReportData = new ArrayList<>();

        for (EntityDataModel entityData : allEntities) {
            expectedReportData.add(Arrays.asList(entityData.getEntityName(),
                    entityData.getPhone_number(),
                    entityData.getSimulationsCount().toString()));
        }

        assertEquals(expectedReportData, marketerController.generateReportAboutAllSimulations());
    }
}