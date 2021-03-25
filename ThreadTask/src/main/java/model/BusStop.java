package model;

import lombok.Data;

@Data
public class BusStop implements Runnable {

    private static final int BUS_SERVICE_TIME_IN_MILLIS = 2000;
    private static final int IDLE_DELAY = 100;
    private static final int MAX_CAPACITY_OF_BUS_STOP = 5;

    private BusStop nextBusStop;
    private int currentCapacity = 0;
    private int numOfBusesDeparted = 0;
    private int numOfBusesExpected = 0;


    public void busesDepart() {

    }

    public void incrementNumOfBusesExpected() {
        this.numOfBusesExpected++;
    }

    @Override
    public void run() {
        while (numOfBusesDeparted != numOfBusesExpected) {
            try {
                Thread.sleep(IDLE_DELAY);
                if (currentCapacity != 0) {
                    Thread.sleep(BUS_SERVICE_TIME_IN_MILLIS);
                    busesDepart();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
