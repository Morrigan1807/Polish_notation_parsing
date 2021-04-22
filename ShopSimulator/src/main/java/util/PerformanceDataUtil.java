package util;

import lombok.NoArgsConstructor;
import lombok.Setter;
import model.database.InputShopDataModel;
import model.database.PerformanceDataModel;

@NoArgsConstructor
public class PerformanceDataUtil {

    @Setter
    private InputShopDataModel inputShopData;
    private double channelLoad = 0;
    private double totalQueueCapacity = 0;

    public PerformanceDataUtil(InputShopDataModel inputShopData) {
        this.inputShopData = inputShopData;
    }

    public PerformanceDataModel calculatePerformanceData() {
        prepareSecondaryParameters();

        return PerformanceDataModel.builder()
                .systemDowntimeProbability(getSystemDowntimeProbability())
                .rejectionProbability(getRejectionProbability())
                .relativeBandwidth(getRelativeBandwidth())
                .absoluteBandwidth(getAbsoluteBandwidth())
                .averageNumberOfBusyChannels(getAverageNumberOfBusyChannels())
                .averageNumberOfRequestsInTheQueue(getAverageNumberOfRequestsInTheQueue())
                .averageNumberOfRequestsInTheSystem(getAverageNumberOfRequestsInTheSystem())
                .averageTimeInQueue(getAverageTimeInQueue())
                .averageTimeInSystem(getAverageTimeInSystem())
                .build();
    }

    public void prepareSecondaryParameters() {
        double queuingLoad = inputShopData.getCustomerIntensity() / inputShopData.getServiceIntensity();

        channelLoad = queuingLoad / inputShopData.getNumberOfCashWindows();
        totalQueueCapacity = (double) inputShopData.getQueueLimit() * inputShopData.getNumberOfCashWindows();
    }

    public boolean isGoodPerformanceData(PerformanceDataModel performanceData) {
        //TODO Add expert analysis of performance data
        return performanceData.getAbsoluteBandwidth() > 0.5;
    }

    public double getSystemDowntimeProbability() {
        double result = 0;
        double temporaryResult = 1;

        if (channelLoad == 1) {
            result++;
            for (int k = 1; k <= inputShopData.getNumberOfCashWindows(); k++) {
                temporaryResult *= (double) inputShopData.getNumberOfCashWindows() / k;
                result += temporaryResult;
            }
            result += temporaryResult * totalQueueCapacity;
        } else {
            result++;
            for (int k = 1; k <= inputShopData.getNumberOfCashWindows(); k++) {
                temporaryResult *= ((double) inputShopData.getNumberOfCashWindows() * channelLoad) / k;
                result += temporaryResult;
            }
            result += (temporaryResult * (channelLoad * (1 - Math.pow(channelLoad, totalQueueCapacity)))) / (1 - channelLoad);
        }
        return 1 / result;
    }

    public double getRejectionProbability() {
        double result = getSystemDowntimeProbability() * Math.pow(channelLoad, inputShopData.getNumberOfCashWindows() + totalQueueCapacity);

        for (int i = 1; i <= inputShopData.getNumberOfCashWindows(); i++) {
            result *= (double) inputShopData.getNumberOfCashWindows() / i;
        }

        return result;
    }

    public double getRelativeBandwidth() {
        return 1 - getRejectionProbability();
    }


    public double getAbsoluteBandwidth() {
        return inputShopData.getCustomerIntensity() * getRelativeBandwidth();
    }

    public double getAverageNumberOfBusyChannels() {
        return getAbsoluteBandwidth() / totalQueueCapacity;
    }

    public double getAverageNumberOfRequestsInTheQueue() {
        double result = getSystemDowntimeProbability();

        if (channelLoad == 1) {
            for (int i = 1; i <= inputShopData.getNumberOfCashWindows(); i++) {
                result *= ((double) inputShopData.getNumberOfCashWindows() / i);
            }

            result *= totalQueueCapacity * (totalQueueCapacity + 1) / 2;
        } else {
            for (int i = 1; i <= inputShopData.getNumberOfCashWindows(); i++) {
                result *= ((double) inputShopData.getNumberOfCashWindows() / i) * channelLoad;
            }

            result *= channelLoad * (1 - (totalQueueCapacity + 1) * Math.pow(channelLoad, totalQueueCapacity) +
                    totalQueueCapacity * Math.pow(channelLoad, totalQueueCapacity + 1)) / Math.pow((1 - channelLoad), 2);
        }

        return result;
    }

    public double getAverageNumberOfRequestsInTheSystem() {
        return getAverageNumberOfBusyChannels() + getAverageNumberOfRequestsInTheQueue();
    }

    public double getAverageTimeInQueue() {
        return (1 / inputShopData.getCustomerIntensity()) * getAverageNumberOfRequestsInTheQueue();
    }

    public double getAverageTimeInSystem() {
        return (1 / inputShopData.getCustomerIntensity()) * getAverageNumberOfRequestsInTheSystem();
    }
}
