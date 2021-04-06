import ParameterizedTests.model.Bus;
import ParameterizedTests.model.BusDepot;
import ParameterizedTests.model.BusStop;
import ParameterizedTests.model.LoggerOfBusStops;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedTestsThreadTask {

    private static Stream<Arguments> getDataForTestWorkProcessOfBus() {
        BusStop solihorskBusStop = new BusStop("Solihorsk");
        BusStop slutskBusStop = new BusStop("Slutsk");
        BusStop nesvizhBusStop = new BusStop("Nesvizh");
        BusStop mirBusStop = new BusStop("Mir");
        BusStop baranovichyBusStop = new BusStop("Baranovichy");
        BusStop kletskBusStop = new BusStop("Kletsk");
        BusStop polonechkaBusStop = new BusStop("Polonechka");

        Bus firstBus = new Bus(0, 1000);
        firstBus.setBusRoute(Arrays.asList(solihorskBusStop, slutskBusStop, nesvizhBusStop, mirBusStop));
        Bus secondBus = new Bus(0, 1000);
        secondBus.setBusRoute(Arrays.asList(solihorskBusStop, slutskBusStop, nesvizhBusStop, baranovichyBusStop));
        Bus thirdBus = new Bus(0, 1000);
        thirdBus.setBusRoute(Arrays.asList(solihorskBusStop, slutskBusStop, kletskBusStop, baranovichyBusStop));
        Bus fourthBus = new Bus(0, 1000);
        fourthBus.setBusRoute(Arrays.asList(solihorskBusStop, slutskBusStop, nesvizhBusStop, polonechkaBusStop));

        return Stream.of(Arguments.arguments(firstBus, getExpectedLogResultForBus(firstBus)),
                Arguments.arguments(secondBus, getExpectedLogResultForBus(secondBus)),
                Arguments.arguments(thirdBus, getExpectedLogResultForBus(thirdBus)),
                Arguments.arguments(fourthBus, getExpectedLogResultForBus(fourthBus)));
    }

    private static String getExpectedLogResultForBus(Bus bus) {
        StringBuilder result = new StringBuilder();

        result.append(String.format("Bus %d arrived to %s bus stop.", bus.getNumberOfBus(), bus.getBusRoute().get(0).getNameOfBusStop()));

        for (int i = 1; i < bus.getBusRoute().size(); i++) {
            result.append(String.format("\nBus %d departed from %s bus stop.", bus.getNumberOfBus(), bus.getBusRoute().get(i - 1).getNameOfBusStop()));
            result.append(String.format("\nBus %d arrived to %s bus stop.", bus.getNumberOfBus(), bus.getBusRoute().get(i).getNameOfBusStop()));
        }

        return result.toString();
    }

    @ParameterizedTest
    @MethodSource("getDataForTestWorkProcessOfBus")
    public void testWorkProcessOfBus(Bus bus, String expectedLog) {
        LoggerOfBusStops.getInstance().clearLog();

        BusDepot busDepot = new BusDepot();
        busDepot.getBuses().add(bus);
        busDepot.startWorking();

        try {
            busDepot.getThreads().get(0).join();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        assertEquals(expectedLog, LoggerOfBusStops.getInstance().toString());
    }
}
