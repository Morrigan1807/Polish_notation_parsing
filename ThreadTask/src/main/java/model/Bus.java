package model;

import lombok.Data;

import java.util.List;

@Data
public class Bus implements Runnable {

    private static final int TIME_TO_BUS_STOP = 2;

    private static int iter = 0;
    private final int numberOfBus;
    private int timeToMoveToNextBusStop = 5000;
    private List<BusStop> busRoute;
    private int nextBusStop = 0;
    private long timeInRoute;
    private int delayBeforeStart;

    public Bus(int delayBeforeStart, int timeToMoveToNextBusStop) {
        numberOfBus = ++iter;

        this.delayBeforeStart = delayBeforeStart;
        this.timeToMoveToNextBusStop = timeToMoveToNextBusStop;
    }

    public void setBusRoute(List<BusStop> busRoute) {
        this.busRoute = busRoute;

        busRoute.forEach(BusStop::incrementNumOfBusesExpected);
    }

    @Override
    public void run() {
        long timeStartRout = 0;

        try {
            Thread.sleep(delayBeforeStart);

            timeStartRout = System.currentTimeMillis();

            busRoute.get(nextBusStop).servingBusInBusStop(this);
            nextBusStop++;

            while (nextBusStop < busRoute.size()) {
                goToNextBusStop();

            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        timeInRoute = System.currentTimeMillis() - timeStartRout;
    }

    private void goToNextBusStop() throws InterruptedException {
        Thread.sleep(timeToMoveToNextBusStop);

        busRoute.get(nextBusStop).servingBusInBusStop(this);

        nextBusStop++;
    }
}
