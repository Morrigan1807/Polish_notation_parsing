package model.database;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PerformanceDataModel {

    private Integer idPerformanceData;
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
