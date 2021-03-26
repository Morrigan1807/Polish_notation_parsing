import model.Bus;
import model.BusDepot;
import model.BusStop;
import model.LoggerOfBusStops;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestThreadTask {

    private static final BusDepot busDepot = new BusDepot();
    private static List<BusStop> busStops;

    @BeforeAll
    public static void setUpBusRoutes() {
        BusStop solihorskBusStop = new BusStop("Solihorsk");
        BusStop slutskBusStop = new BusStop("Slutsk");
        BusStop nesvizhBusStop = new BusStop("Nesvizh");
        BusStop mirBusStop = new BusStop("Mir");
        BusStop baranovichyBusStop = new BusStop("Baranovichy");
        BusStop kletskBusStop = new BusStop("Kletsk");
        BusStop polonechkaBusStop = new BusStop("Polonechka");

        busStops = Arrays.asList(solihorskBusStop, slutskBusStop, nesvizhBusStop, mirBusStop, baranovichyBusStop,
                kletskBusStop, polonechkaBusStop);

        Bus firstBus = new Bus(10000, 5000);
        firstBus.setBusRoute(Arrays.asList(solihorskBusStop, slutskBusStop, nesvizhBusStop, mirBusStop));
        Bus secondBus = new Bus(0, 7000);
        secondBus.setBusRoute(Arrays.asList(solihorskBusStop, slutskBusStop, nesvizhBusStop, baranovichyBusStop));
        Bus thirdBus = new Bus(6000, 3000);
        thirdBus.setBusRoute(Arrays.asList(solihorskBusStop, slutskBusStop, kletskBusStop, baranovichyBusStop));
        Bus fourthBus = new Bus(1000, 12000);
        fourthBus.setBusRoute(Arrays.asList(solihorskBusStop, slutskBusStop, nesvizhBusStop, polonechkaBusStop));

        busDepot.setBuses(Arrays.asList(firstBus, secondBus, thirdBus, fourthBus));
        busDepot.startWorking();

        busDepot.getThreads().forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });
    }

    @Test
    public void testWorkOfBusesAndBusStopsWithLogger() {
        String expectedLog = "Bus 2 arrived to Solihorsk bus stop.\n" +
                "Bus 2 departed from Solihorsk bus stop.\n" +
                "Bus 4 arrived to Solihorsk bus stop.\n" +
                "Bus 4 departed from Solihorsk bus stop.\n" +
                "Bus 3 arrived to Solihorsk bus stop.\n" +
                "Bus 3 departed from Solihorsk bus stop.\n" +
                "Bus 2 arrived to Slutsk bus stop.\n" +
                "Bus 2 departed from Slutsk bus stop.\n" +
                "Bus 1 arrived to Solihorsk bus stop.\n" +
                "Bus 1 departed from Solihorsk bus stop.\n" +
                "Bus 3 arrived to Slutsk bus stop.\n" +
                "Bus 3 departed from Slutsk bus stop.\n" +
                "Bus 4 arrived to Slutsk bus stop.\n" +
                "Bus 4 departed from Slutsk bus stop.\n" +
                "Bus 3 arrived to Kletsk bus stop.\n" +
                "Bus 3 departed from Kletsk bus stop.\n" +
                "Bus 1 arrived to Slutsk bus stop.\n" +
                "Bus 1 departed from Slutsk bus stop.\n" +
                "Bus 2 arrived to Nesvizh bus stop.\n" +
                "Bus 2 departed from Nesvizh bus stop.\n" +
                "Bus 3 arrived to Baranovichy bus stop.\n" +
                "Bus 3 departed from Baranovichy bus stop.\n" +
                "Bus 1 arrived to Nesvizh bus stop.\n" +
                "Bus 1 departed from Nesvizh bus stop.\n" +
                "Bus 2 arrived to Baranovichy bus stop.\n" +
                "Bus 2 departed from Baranovichy bus stop.\n" +
                "Bus 4 arrived to Nesvizh bus stop.\n" +
                "Bus 4 departed from Nesvizh bus stop.\n" +
                "Bus 1 arrived to Mir bus stop.\n" +
                "Bus 1 departed from Mir bus stop.\n" +
                "Bus 4 arrived to Polonechka bus stop.";

        assertEquals(expectedLog, LoggerOfBusStops.getInstance().toString());
    }

    @Test
    public void testFirstBusTimeSpent() {
        double expectedTimeSpent = 23;
        double actualTimeSpent = (double) busDepot.getBuses().get(0).getTimeInRoute() / 1000;

        assertEquals(expectedTimeSpent, actualTimeSpent, 0.1);
    }

    @Test
    public void testSecondBusTimeSpent() {
        double expectedTimeSpent = 29;
        double actualTimeSpent = (double) busDepot.getBuses().get(1).getTimeInRoute() / 1000;

        assertEquals(expectedTimeSpent, actualTimeSpent, 0.1);
    }

    @Test
    public void testThirdBusTimeSpent() {
        double expectedTimeSpent = 17;
        double actualTimeSpent = (double) busDepot.getBuses().get(2).getTimeInRoute() / 1000;

        assertEquals(expectedTimeSpent, actualTimeSpent, 0.1);
    }

    @Test
    public void testFourthBusTimeSpent() {
        double expectedTimeSpent = 44;
        double actualTimeSpent = (double) busDepot.getBuses().get(3).getTimeInRoute() / 1000;

        assertEquals(expectedTimeSpent, actualTimeSpent, 0.1);
    }

    @Test
    public void testDepartedEqualsExpectedForEachBusStop() {
        for (BusStop busStop : busStops) {
            assertEquals(busStop.getNumOfBusesExpected(), busStop.getNumOfBusesDeparted());
        }
    }
}
