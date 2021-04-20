package controller;

import lombok.Getter;
import lombok.Setter;
import model.database.AccountModel;
import model.database.InputShopDataModel;
import model.database.PerformanceDataModel;
import model.database.SimulationModel;
import model.shop.Shop;
import repository.InputShopDataRepository;
import repository.PerformanceDataRepository;
import repository.SimulationRepository;
import repository.sqldatabase.InputShopDataRepositorySql;
import repository.sqldatabase.PerformanceDataRepositorySql;
import repository.sqldatabase.SimulationRepositorySql;
import util.PerformanceDataUtil;

import java.util.ArrayList;
import java.util.List;

public class ClientController {

    //TODO Add configuration ling
    private final InputShopDataRepository inputShopDataRepository = new InputShopDataRepositorySql();
    //TODO Add configuration ling
    private final PerformanceDataRepository performanceDataRepository = new PerformanceDataRepositorySql();
    //TODO Add configuration ling
    private final SimulationRepository simulationRepository = new SimulationRepositorySql();
    private final List<String> logList = new ArrayList<>();
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
        return InputShopDataModel.builder()
                .numberOfCashWindows(numberOfCashWindows)
                .queueLimit(queueLimit)
                .customerIntensity(customerIntensity)
                .serviceIntensity(serviceIntensity)
                .simulationRunTime(simulationRunTime)
                .build();
    }

    public Shop startSimulation() {
        //TODO Add jump to new page and output simulation
        return new Shop(getInputShopData(), logList);
    }

    public PerformanceDataModel getPerformanceData() {
        return new PerformanceDataUtil(getInputShopData()).calculatePerformanceData();
    }

    public String getRecommendation(PerformanceDataModel performanceData) {
        //TODO Rewrite for changing color of simulation in result
        return new PerformanceDataUtil().isGoodPerformanceData(performanceData) ? "It's good!" : "It's bad!";
    }

    public void saveSimulation() {
        //TODO Add insert query to DB
    }

    public void setAllSimulations(List<SimulationModel> allSimulations) {
        //TODO Add select query to DB and writing in allSimulations
        this.allSimulations = allSimulations;
    }

    public SimulationModel deleteSimulation(int indexOfSimulationForDelete) {
        //TODO Add delete query to DB
        simulationRepository.deleteSimulation(allSimulations.get(indexOfSimulationForDelete).getIdSimulation());
        return allSimulations.remove(indexOfSimulationForDelete);
    }

    public void changeDataInSimulation(int indexOfSimulation, SimulationModel changedSimulation) {
        //TODO Add update query to DB
        simulationRepository.updateSimulation(indexOfSimulation, changedSimulation);
        allSimulations.set(indexOfSimulation, changedSimulation);
    }

    public SimulationModel getSimulation(int indexOfSimulation) {
        //TODO Add jump to new page with info about selected simulation
        return allSimulations.get(indexOfSimulation);
    }
}
