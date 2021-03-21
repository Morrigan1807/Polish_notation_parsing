package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BusStopTest {
    @Test
    void testBusesDepartOneHasNextBusStopCase() {
        BusStop firstBusStopCase = new BusStop.Builder()
                .withNumOfBusesExpected(10)
                .withQueueOfBusStop(10)
                .build();
        BusStop secondBusStopCase = new BusStop.Builder()
                .withNumOfBusesExpected(10)
                .build();
        firstBusStopCase.setNextBusStop(secondBusStopCase);

        assertDoesNotThrow(() -> new Thread(firstBusStopCase).start());
    }

    @Test
    void testBusesDepartOneHasNotNextBusStopCase() {
        BusStop firstBusStopCase = new BusStop.Builder()
                .withNumOfBusesExpected(14)
                .withMaxCapacityOfBusStop(4)
                .withQueueOfBusStop(14)
                .build();

        assertDoesNotThrow(() -> new Thread(firstBusStopCase).start());
    }
}