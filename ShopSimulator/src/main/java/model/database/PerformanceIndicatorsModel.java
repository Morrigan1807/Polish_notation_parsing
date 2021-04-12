package model.database;

import lombok.Data;

@Data
public class PerformanceIndicatorsModel {

    private Integer idPerformanceIndicators;
    private Integer idInputShopData;
    private Double systemDowntimeProbability;
    private Double rejectionProbability;
    private Double absoluteBandwidth;
    private Double relativeBandwidth;
    private Double averageNumberOfBusyChannels;
    private Double averageNumberOfRequestsInTheQueue;
    private Double averageNumberOfRequestsInTheSystem;
    private Double averageTimeInQueue;
    private Double averageTimeInSystem;
}
