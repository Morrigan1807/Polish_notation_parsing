package model;

import lombok.Data;

@Data
public class BusStop implements Runnable {
    private BusStop nextBusStop;
    private int currentCapacity = 0;
    private int maxCapacityOfBusStop = 5;
    private int queueOfBusStop = 0;
    private int numOfBusesDeparted = 0;
    private int numOfBusesExpected = 5;
    private static final int BUS_SERVICE_TIME_IN_MILLIS = 50;
    private static final int IDLE_DELAY = 100;

    public void busesDepart() {
        if (nextBusStop != null) {
            nextBusStop.addBusesToQueue(currentCapacity);
        }

        numOfBusesDeparted += currentCapacity;

        synchronized (this) {
            if (queueOfBusStop <= maxCapacityOfBusStop) {
                currentCapacity = queueOfBusStop;
                queueOfBusStop = 0;
            } else {
                currentCapacity = maxCapacityOfBusStop;
                queueOfBusStop -= maxCapacityOfBusStop;
            }
        }
    }

    private void addBusesToQueue(int numberOdBuses) {
        synchronized (this) {
            this.queueOfBusStop = this.queueOfBusStop + numberOdBuses;
        }
    }

    @Override
    public void run() {
        while (numOfBusesDeparted != numOfBusesExpected) {
            try {
                Thread.sleep(IDLE_DELAY);
                if (currentCapacity != 0 || queueOfBusStop != 0) {
                    Thread.sleep(BUS_SERVICE_TIME_IN_MILLIS);
                    busesDepart();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Builder {
        private final BusStop newBusStop;

        public Builder() {
            newBusStop = new BusStop();
        }

        public Builder withMaxCapacityOfBusStop(int maxCapacityOfBusStop) {
            newBusStop.setMaxCapacityOfBusStop(maxCapacityOfBusStop);
            return this;
        }

        public Builder withQueueOfBusStop(int queueOfBusStop) {
            newBusStop.setQueueOfBusStop(queueOfBusStop);
            return this;
        }

        public Builder withNumOfBusesExpected(int numOfBusesExpected) {
            newBusStop.setNumOfBusesExpected(numOfBusesExpected);
            return this;
        }

        public Builder withNextBusStop(BusStop nextBusStop) {
            newBusStop.setNextBusStop(nextBusStop);
            return this;
        }

        public BusStop build() {
            return newBusStop;
        }
    }
}
