package model.database;

import lombok.Data;

@Data
public class InputShopDataModel {

    private Integer idInputShopData;
    private Integer numberOfCashWindows;
    private Integer queueLimit;
    private Double customerIntensity;
    private Double serviceIntensity;
    private Double simulationRunTime;
}
