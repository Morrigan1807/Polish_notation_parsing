package controller;

import model.database.InputShopDataModel;
import model.database.PerformanceIndicatorsModel;
import model.database.SimulationModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientControllerTest {

    private static final List<SimulationModel> allSimulations = new ArrayList<>();
    private static final ClientController clientController = new ClientController();

    @BeforeAll
    public static void prepareClientController() {
        clientController.setNumberOfCashWindows(4);
        clientController.setQueueLimit(7);
        clientController.setCustomerIntensity(1.1);
        clientController.setServiceIntensity(4.2);
        clientController.setSimulationRunTime(1.0);

        SimulationModel firstSimulation = new SimulationModel();
        firstSimulation.setIdSimulation(1);
        firstSimulation.setRecommendation("It's good!");

        SimulationModel secondSimulation = new SimulationModel();
        secondSimulation.setIdSimulation(2);
        secondSimulation.setRecommendation("It's bad!");

        allSimulations.add(firstSimulation);
        allSimulations.add(secondSimulation);
    }

    @Test
    public void testGetInputShopData() {
        InputShopDataModel expectedInputShopData = new InputShopDataModel();
        expectedInputShopData.setNumberOfCashWindows(4);
        expectedInputShopData.setQueueLimit(7);
        expectedInputShopData.setCustomerIntensity(1.1);
        expectedInputShopData.setServiceIntensity(4.2);
        expectedInputShopData.setSimulationRunTime(1.0);

        assertEquals(expectedInputShopData, clientController.getInputShopData());
    }

    @Test
    public void testStartSimulation() {
        assertNotNull(clientController.startSimulation());
    }

    @Test
    public void testGetPerformanceIndicators() {
        assertNotNull(clientController.getPerformanceIndicators());
    }

    @Test
    public void testShowRecommendationGoodCase() {
        PerformanceIndicatorsModel performanceIndicatorsForCheck = new PerformanceIndicatorsModel();
        performanceIndicatorsForCheck.setAbsoluteBandwidth(2.1);

        assertEquals("It's good!", clientController.showRecommendation(performanceIndicatorsForCheck));
    }

    @Test
    public void testShowRecommendationBadCase() {
        PerformanceIndicatorsModel performanceIndicatorsForCheck = new PerformanceIndicatorsModel();
        performanceIndicatorsForCheck.setAbsoluteBandwidth(0.5);

        assertEquals("It's bad!", clientController.showRecommendation(performanceIndicatorsForCheck));
    }

    @Test
    public void testSetAllSimulations() {
        clientController.setAllSimulations(allSimulations);

        assertEquals(allSimulations, clientController.getAllSimulations());
    }

    @Test
    public void testDeleteSimulation() {
        clientController.setAllSimulations(allSimulations);
        SimulationModel deletedSimulation = clientController.deleteSimulation(0);

        assertEquals(-1, clientController.getAllSimulations().indexOf(deletedSimulation));
    }

    @Test
    public void testChangeDataInSimulation() {
        clientController.setAllSimulations(allSimulations);

        SimulationModel changedSimulation = new SimulationModel();
        changedSimulation.setIdSimulation(3);
        changedSimulation.setRecommendation("It's good!");

        clientController.changeDataInSimulation(1, changedSimulation);

        assertEquals(changedSimulation, clientController.getAllSimulations().get(1));
    }
}