package threadtask;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ThreadTaskTest {
    @ParameterizedTest
    @CsvFileSource(resources = "testDataTestThreadTaskDoesNotThrowCaseThreadTask.csv")
    void testThreadTaskDoesNotThrowCase(int numberOfBusStops, int numberOfBuses) {
        assertDoesNotThrow(() -> new ThreadTask().threadTask(numberOfBusStops, numberOfBuses));
    }
}