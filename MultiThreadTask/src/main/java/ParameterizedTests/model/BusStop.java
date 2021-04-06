package ParameterizedTests.model;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.Semaphore;

@Data
@Log4j2
public class BusStop {

    private static final int BUS_SERVICE_TIME_IN_MILLIS = 2000;
    private final Semaphore semaphore = new Semaphore(2, true);
    private int numOfBusesDeparted = 0;
    private int numOfBusesExpected = 0;
    private String nameOfBusStop = "";
    private LoggerOfBusStops loggerOfBusStops = LoggerOfBusStops.getInstance();

    public BusStop(String nameOfBusStop) {
        this.nameOfBusStop = nameOfBusStop;
    }

    public void incrementNumOfBusesExpected() {
        this.numOfBusesExpected++;
    }

    public void servingBusInBusStop(Bus bus) {
        try {
            busArrives(bus);
            busDeparts(bus);
        } catch (InterruptedException interruptedException) {
            log.error(interruptedException);
        }
    }

    private void busArrives(Bus bus) throws InterruptedException {
        semaphore.acquire();

        Thread.sleep(BUS_SERVICE_TIME_IN_MILLIS);

        loggerOfBusStops.addInformationInLogger(String.format("Bus %d arrived to %s bus stop.", bus.getNumberOfBus(), nameOfBusStop));
    }

    private void busDeparts(Bus bus) {
        synchronized (this) {
            numOfBusesDeparted++;
        }

        loggerOfBusStops.addInformationInLogger(String.format("Bus %d departed from %s bus stop.", bus.getNumberOfBus(), nameOfBusStop));

        semaphore.release();
    }
}
