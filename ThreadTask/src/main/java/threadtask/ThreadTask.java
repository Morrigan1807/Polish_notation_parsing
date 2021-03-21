package threadtask;

import model.BusStop;

import java.util.ArrayList;
import java.util.List;

public class ThreadTask {
    public void threadTask(int numberOfBusStops, int numberOfBuses) {
        List<BusStop> busStops = new ArrayList<>();

        busStops.add(new BusStop.Builder()
                .withNumOfBusesExpected(numberOfBuses)
                .build());
        for (int i = 0; i < numberOfBusStops; i++) {
            busStops.add(0, new BusStop.Builder()
                    .withNumOfBusesExpected(numberOfBuses)
                    .withNextBusStop(busStops.get(0))
                    .build());
        }

        List<Thread> threadsOfBusStops = new ArrayList<>();

        busStops.get(0).setQueueOfBusStop(numberOfBuses);
        for (BusStop busStop : busStops) {
            threadsOfBusStops.add(new Thread(busStop));
            threadsOfBusStops.get(threadsOfBusStops.size() - 1).start();
        }

        try {
            threadsOfBusStops.get(threadsOfBusStops.size() - 1).join();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
