package model.database;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimulationModel {

    private Integer idSimulation;
    private String idAccount;
    private Integer idInputShopData;
    private Integer idPerformanceData;
    private String recommendation;
    private InputShopDataModel inputShopData;
    private PerformanceDataModel performanceData;
}
