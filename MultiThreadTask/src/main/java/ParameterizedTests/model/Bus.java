package ParameterizedTests.model;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Data
@Log4j2
public class Bus implements Runnable {

    private static final int TIME_TO_BUS_STOP = 2;
    private static int iterationNumberOfBusStop = 0;
    private final int numberOfBus;
    private int timeToMoveToNextBusStop = 5000;
    private int nextBusStop = 0;
    private int delayBeforeStart;
    private long timeInRoute;
    private List<BusStop> busRoute;

    public Bus(int delayBeforeStart, int timeToMoveToNextBusStop) {
        numberOfBus = ++iterationNumberOfBusStop;

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
            log.error(interruptedException);
        }

        timeInRoute = System.currentTimeMillis() - timeStartRout;
    }

    private void goToNextBusStop() throws InterruptedException {
        Thread.sleep(timeToMoveToNextBusStop);

        busRoute.get(nextBusStop).servingBusInBusStop(this);

        nextBusStop++;
    }
}
