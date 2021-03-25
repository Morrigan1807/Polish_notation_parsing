package model;

import lombok.Data;

import java.util.concurrent.Semaphore;

@Data
public class BusStop {

    private static final int BUS_SERVICE_TIME_IN_MILLIS = 2000;

    private final Semaphore semaphore = new Semaphore(2, true);
    private String nameOfBusStop = "";
    private int numOfBusesDeparted = 0;
    private int numOfBusesExpected = 0;
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
            interruptedException.printStackTrace();
        }
    }

    private void busArrives(Bus bus) throws InterruptedException {
        semaphore.acquire();

        Thread.sleep(BUS_SERVICE_TIME_IN_MILLIS);

        loggerOfBusStops.addInformationInLogger("Bus " + bus.getNumberOfBus() + " arrived to " + nameOfBusStop + " bus stop.");
    }

    private void busDeparts(Bus bus) {
        synchronized (this) {
            numOfBusesDeparted++;
        }

        loggerOfBusStops.addInformationInLogger("Bus " + bus.getNumberOfBus() + " departed from " + nameOfBusStop + " bus stop.");

        semaphore.release();
    }
}
