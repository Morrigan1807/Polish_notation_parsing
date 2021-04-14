package controller;

import model.database.AccountModel;
import model.database.InputShopDataModel;
import model.database.PerformanceIndicatorsModel;
import model.database.SimulationModel;
import model.shop.Shop;
import repository.InputShopDataRepository;
import repository.PerformanceIndicatorsRepository;
import repository.SimulationRepository;
import util.PerformanceIndicatorsUtil;

import java.util.ArrayList;
import java.util.List;

public class ClientController {

    private InputShopDataRepository inputShopDataRepository;
    private PerformanceIndicatorsRepository performanceIndicatorsRepository;
    private SimulationRepository simulationRepository;
    private List<String> logList = new ArrayList<>();
    private List<SimulationModel> allSimulations = new ArrayList<>();
    private AccountModel currentAccount;
    private Integer numberOfCashWindows;
    private Integer queueLimit;
    private Double customerIntensity;
    private Double serviceIntensity;
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

    public void showAllSimulations() {
        allSimulations = simulationRepository.selectAllSimulationsByIdEntity(currentAccount.getLogin());
    }

    public void deleteSimulation(int indexOfSimulationForDelete) {
        simulationRepository.deleteSimulation(allSimulations.get(indexOfSimulationForDelete).getIdSimulation());
        allSimulations.remove(indexOfSimulationForDelete);
    }

    public void changeDataInSimulation(int indexOfSimulation) {
        SimulationModel currentSimulation = allSimulations.get(indexOfSimulation);

        inputShopDataRepository.updateInputShopData(currentSimulation.getIdInputShopData(), getInputShopData());
        performanceIndicatorsRepository.updatePerformanceIndicators(currentSimulation.getIdPerformanceIndicators(), getPerformanceIndicators());


    }

    public Integer getNumberOfCashWindows() {
        return numberOfCashWindows;
    }

    public void setNumberOfCashWindows(Integer numberOfCashWindows) {
        this.numberOfCashWindows = numberOfCashWindows;
    }

    public Integer getQueueLimit() {
        return queueLimit;
    }

    public void setQueueLimit(Integer queueLimit) {
        this.queueLimit = queueLimit;
    }

    public Double getCustomerIntensity() {
        return customerIntensity;
    }

    public void setCustomerIntensity(Double customerIntensity) {
        this.customerIntensity = customerIntensity;
    }

    public Double getServiceIntensity() {
        return serviceIntensity;
    }

    public void setServiceIntensity(Double serviceIntensity) {
        this.serviceIntensity = serviceIntensity;
    }

    public Double getSimulationRunTime() {
        return simulationRunTime;
    }

    public void setSimulationRunTime(Double simulationRunTime) {
        this.simulationRunTime = simulationRunTime;
    }
}
