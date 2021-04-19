package controller;

import lombok.Getter;
import lombok.Setter;
import model.database.AccountModel;
import model.database.InputShopDataModel;
import model.database.PerformanceIndicatorsModel;
import model.database.SimulationModel;
import model.shop.Shop;
import repository.InputShopDataRepository;
import repository.PerformanceIndicatorsRepository;
import repository.SimulationRepository;
import repository.sqldatabase.InputShopDataRepositorySql;
import repository.sqldatabase.PerformanceIndicatorsRepositorySql;
import repository.sqldatabase.SimulationRepositorySql;
import util.PerformanceIndicatorsUtil;

import java.util.ArrayList;
import java.util.List;

public class ClientController {

    private InputShopDataRepository inputShopDataRepository = new InputShopDataRepositorySql();
    private PerformanceIndicatorsRepository performanceIndicatorsRepository = new PerformanceIndicatorsRepositorySql();
    private SimulationRepository simulationRepository = new SimulationRepositorySql();
    private List<String> logList = new ArrayList<>();
    @Getter
    private List<SimulationModel> allSimulations = new ArrayList<>();
    private AccountModel currentAccount;
    @Getter
    @Setter
    private Integer numberOfCashWindows;
    @Getter
    @Setter
    private Integer queueLimit;
    @Getter
    @Setter
    private Double customerIntensity;
    @Getter
    @Setter
    private Double serviceIntensity;
    @Getter
    @Setter
    private Double simulationRunTime;

    public InputShopDataModel getInputShopData() {
        InputShopDataModel inputShopData = new InputShopDataModel();
        inputShopData.setNumberOfCashWindows(numberOfCashWindows);
        inputShopData.setQueueLimit(queueLimit);
        inputShopData.setCustomerIntensity(customerIntensity);
        inputShopData.setServiceIntensity(serviceIntensity);
        inputShopData.setSimulationRunTime(simulationRunTime);

        return inputShopData;
    }

    public Shop startSimulation() {
        return new Shop(getInputShopData(), logList);
    }

    public PerformanceIndicatorsModel getPerformanceIndicators() {
        return new PerformanceIndicatorsUtil(getInputShopData()).calculatePerformanceIndicators();
    }

    public String showRecommendation(PerformanceIndicatorsModel performanceIndicators) {
        return new PerformanceIndicatorsUtil().isGoodPerformanceIndicators(performanceIndicators) ? "It's good!" : "It's bad!";
    }

    public void setAllSimulations(List<SimulationModel> allSimulations) {
        this.allSimulations = allSimulations;
    }

    public SimulationModel deleteSimulation(int indexOfSimulationForDelete) {
        simulationRepository.deleteSimulation(allSimulations.get(indexOfSimulationForDelete).getIdSimulation());
        return allSimulations.remove(indexOfSimulationForDelete);
    }

    public void changeDataInSimulation(int indexOfSimulation, SimulationModel changedSimulation) {
        simulationRepository.updateSimulation(indexOfSimulation, changedSimulation);
        allSimulations.set(indexOfSimulation, changedSimulation);
    }
}
