package util;

import lombok.AllArgsConstructor;
import model.database.InputShopDataModel;
import model.database.PerformanceIndicatorsModel;

@AllArgsConstructor
public class PerformanceIndicatorsUtil {

    private InputShopDataModel inputShopDataModel;

    public void calculatePerformanceIndicators(PerformanceIndicatorsModel performanceIndicatorsModel) {
        performanceIndicatorsModel.setSystemDowntimeProbability(getSystemDowntimeProbability());
        performanceIndicatorsModel.setRejectionProbability(getRejectionProbability());
        performanceIndicatorsModel.setAbsoluteBandwidth(getAbsoluteBandwidth());
        performanceIndicatorsModel.setRelativeBandwidth(getRelativeBandwidth());
        performanceIndicatorsModel.setAverageNumberOfBusyChannels(getAverageNumberOfBusyChannels());
        performanceIndicatorsModel.setAverageNumberOfRequestsInTheQueue(getAverageNumberOfRequestsInTheQueue());
        performanceIndicatorsModel.setAverageNumberOfRequestsInTheSystem(getAverageNumberOfRequestsInTheSystem());
        performanceIndicatorsModel.setAverageTimeInQueue(getAverageTimeInQueue());
        performanceIndicatorsModel.setAverageTimeInSystem(getAverageTimeInSystem());
    }

    private double getSystemDowntimeProbability() {
        return 1.1;
    }

    private double getRejectionProbability() {
        return 1.1;
    }

    private double getAbsoluteBandwidth() {
        return 1.1;
    }

    private double getRelativeBandwidth() {
        return 1.1;
    }

    private double getAverageNumberOfBusyChannels() {
        return 1.1;
    }

    private double getAverageNumberOfRequestsInTheQueue() {
        return 1.1;
    }

    private double getAverageNumberOfRequestsInTheSystem() {
        return 1.1;
    }

    private double getAverageTimeInQueue() {
        return 1.1;
    }

    private double getAverageTimeInSystem() {
        return 1.1;
    }
}
