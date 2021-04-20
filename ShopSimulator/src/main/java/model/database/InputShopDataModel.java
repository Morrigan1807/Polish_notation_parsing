package model.database;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InputShopDataModel {

    private Integer idInputShopData;
    private Integer numberOfCashWindows;
    private Integer queueLimit;
    private Double customerIntensity;
    private Double serviceIntensity;
    private Double simulationRunTime;
}
