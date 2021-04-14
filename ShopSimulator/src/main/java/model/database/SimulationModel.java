package model.database;

import lombok.Data;

@Data
public class SimulationModel {

    private Integer idSimulation;
    private String idAccount;
    private Integer idInputShopData;
    private Integer idPerformanceIndicators;
    private String recommendation;
    private InputShopDataModel inputShopData;
    private PerformanceIndicatorsModel performanceIndicators;
}
