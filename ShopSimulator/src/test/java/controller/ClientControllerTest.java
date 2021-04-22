package controller;

import model.database.InputShopDataModel;
import model.database.PerformanceDataModel;
import model.database.SimulationModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientControllerTest {

    private final List<SimulationModel> allSimulations = new ArrayList<>();
    private final ClientController clientController = new ClientController();

    @BeforeEach
    public void prepareClientController() {
        clientController.setNumberOfCashWindows(4);
        clientController.setQueueLimit(7);
        clientController.setCustomerIntensity(1.1);
        clientController.setServiceIntensity(4.2);
        clientController.setSimulationRunTime(1.0);

        allSimulations.add(SimulationModel.builder().idSimulation(1).recommendation("It's good!").build());
        allSimulations.add(SimulationModel.builder().idSimulation(2).recommendation("It's bad!").build());
    }

    @Test
    public void testGetInputShopData() {
        assertEquals(InputShopDataModel.builder().numberOfCashWindows(4).queueLimit(7).customerIntensity(1.1)
                .serviceIntensity(4.2).simulationRunTime(1.0).build(), clientController.getInputShopData());
    }

    @Test
    public void testGetInputShopDataDoesNotThrow() {
        assertDoesNotThrow(clientController::getInputShopData);
    }

    @Test
    public void testStartSimulation() {
        assertNotNull(clientController.startSimulation());
    }

    @Test
    public void testStartSimulationDoesNotThrow() {
        assertDoesNotThrow(clientController::startSimulation);
    }

    @Test
    public void testGetPerformanceData() {
        assertNotNull(clientController.getPerformanceData());
    }

    @Test
    public void testGetPerformanceDataDoesNotThrow() {
        assertDoesNotThrow(clientController::getPerformanceData);
    }

    @Test
    public void testShowRecommendationGoodCase() {
        //TODO Rewrite test for expert analysis
        assertEquals("It's good!", clientController.getRecommendation(PerformanceDataModel.builder().absoluteBandwidth(0.85).build()));
    }

    @Test
    public void testShowRecommendationBadCase() {
        //TODO Rewrite test for expert analysis
        assertEquals("It's bad!", clientController.getRecommendation(PerformanceDataModel.builder().absoluteBandwidth(0.3).build()));
    }

    @Test
    public void testSaveSimulation() {
        assertDoesNotThrow(clientController::saveSimulation);
    }

    @Test
    public void testSetAllSimulations() {
        clientController.setAllSimulations(allSimulations);

        assertEquals(allSimulations, clientController.getAllSimulations());
    }

    @Test
    public void testSetAllSimulationsDoesNotThrow() {
        assertDoesNotThrow(() -> clientController.setAllSimulations(allSimulations));
    }

    @Test
    public void testChangeDataInSimulation() {
        clientController.setAllSimulations(allSimulations);
        SimulationModel changedSimulation = SimulationModel.builder().idSimulation(3).recommendation("It's good!").build();
        clientController.changeDataInSimulation(1, changedSimulation);

        assertEquals(changedSimulation, clientController.getAllSimulations().get(1));
    }

    @Test
    public void testChangeDataInSimulationDoesNotThrow() {
        clientController.setAllSimulations(allSimulations);
        SimulationModel changedSimulation = SimulationModel.builder().idSimulation(3).recommendation("It's good!").build();

        assertDoesNotThrow(() -> clientController.changeDataInSimulation(1, changedSimulation));
    }

    @Test
    public void testDeleteSimulation() {
        clientController.setAllSimulations(allSimulations);
        SimulationModel deletedSimulation = clientController.deleteSimulation(0);

        assertEquals(-1, clientController.getAllSimulations().indexOf(deletedSimulation));
    }

    @Test
    public void testDeleteSimulationDoesNotThrow() {
        clientController.setAllSimulations(allSimulations);

        assertDoesNotThrow(() -> clientController.deleteSimulation(0));
    }

    @Test
    public void testGetSimulation() {
        clientController.setAllSimulations(allSimulations);
        assertNotNull(clientController.getSimulation(0));
    }

    @Test
    public void testGetSimulationDoesNotThrow() {
        clientController.setAllSimulations(allSimulations);
        assertDoesNotThrow(() -> clientController.getSimulation(0));
    }
}