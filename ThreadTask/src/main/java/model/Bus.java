package model;

import lombok.Data;

import java.util.List;

@Data
public class Bus {

    private static int iter = 0;
    private final int numberOfBus;
    private int timeToMoveToNextBusStop = 10;
    private List<BusStop> busRoute;
    private BusStop currentBusStop;
    private static final int TIME_TO_BUS_STOP = 2;

    Bus() {
        numberOfBus = ++iter;
    }
}
