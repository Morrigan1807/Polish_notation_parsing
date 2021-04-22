package complex;

import controller.ClientController;
import controller.Controller;
import model.database.AccountModel;
import model.database.SimulationModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexTest {

    @Test
    public void testCreateAndCheckNewSimulation() {
        ClientController clientController = new ClientController();
        clientController.setNumberOfCashWindows(4);
        clientController.setQueueLimit(7);
        clientController.setCustomerIntensity(1.1);
        clientController.setServiceIntensity(4.2);
        clientController.setSimulationRunTime(1.0);

        assertDoesNotThrow(() -> createAndCheckNewSimulation(clientController));
    }

    @Test
    public void testViewAndDeleteSimulation() {
        List<SimulationModel> allSimulations = new ArrayList<>();
        allSimulations.add(SimulationModel.builder().idSimulation(1).recommendation("It's good!").build());
        allSimulations.add(SimulationModel.builder().idSimulation(2).recommendation("It's bad!").build());

        ClientController clientController = new ClientController();
        clientController.setNumberOfCashWindows(4);
        clientController.setQueueLimit(7);
        clientController.setCustomerIntensity(1.1);
        clientController.setServiceIntensity(4.2);
        clientController.setSimulationRunTime(1.0);
        clientController.setAllSimulations(allSimulations);

        assertDoesNotThrow(() -> {
            viewAndDeleteSimulation(clientController);
        });
    }

    @Test
    public void testIncorrectAndCorrectDataForAuthorization() {
        Controller controller = new Controller();

        assertFalse(controller.checkAccount());

        controller.setCurrentAccount(AccountModel.builder().login("admin").password("admin").accessLevel("admin").build());
        assertEquals("Going to admin page.", controller.loginOnSite());
    }

    private void viewAndDeleteSimulation(ClientController clientController) {
        clientController.getAllSimulations();
        clientController.getSimulation(1);
        clientController.deleteSimulation(1);
    }

    private void createAndCheckNewSimulation(ClientController clientController) {
        clientController.getInputShopData();
        clientController.saveSimulation();
        clientController.getPerformanceData();
        clientController.getAllSimulations();
    }
}
