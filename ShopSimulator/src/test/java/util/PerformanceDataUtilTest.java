package util;

import model.database.InputShopDataModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PerformanceDataUtilTest {

    public static final PerformanceDataUtil PERFORMANCE_DATA_UTIL = new PerformanceDataUtil();

    @BeforeAll
    public static void prepareInputData() {
        PERFORMANCE_DATA_UTIL.setInputShopData(InputShopDataModel.builder()
                .numberOfCashWindows(4)
                .queueLimit(7)
                .customerIntensity(0.5)
                .serviceIntensity(3.0)
                .build());
        PERFORMANCE_DATA_UTIL.prepareSecondaryParameters();
    }

    @Test
    public void testCalculatePerformanceData() {
        assertNotNull(PERFORMANCE_DATA_UTIL.calculatePerformanceData());
    }

    @Test
    public void testGetSystemDowntimeProbability() {
        assertEquals(0.85, PERFORMANCE_DATA_UTIL.getSystemDowntimeProbability(), 0.1);
    }

    @Test
    public void testGetRejectionProbability() {
        assertEquals(0, PERFORMANCE_DATA_UTIL.getRejectionProbability(), 0.1);
    }

    @Test
    public void testGetRelativeBandwidth() {
        assertEquals(1, PERFORMANCE_DATA_UTIL.getRelativeBandwidth(), 0.1);
    }

    @Test
    public void testGetAbsoluteBandwidth() {
        assertEquals(0.5, PERFORMANCE_DATA_UTIL.getAbsoluteBandwidth(), 0.1);
    }

    @Test
    public void testGetAverageNumberOfBusyChannels() {
        assertEquals(0.02, PERFORMANCE_DATA_UTIL.getAverageNumberOfBusyChannels(), 0.1);
    }

    @Test
    public void testGetAverageNumberOfRequestsInTheQueue() {
        assertEquals(0.000001, PERFORMANCE_DATA_UTIL.getAverageNumberOfRequestsInTheQueue(), 0.000001);
    }

    @Test
    public void testGetAverageNumberOfRequestsInTheSystem() {
        assertEquals(0.02, PERFORMANCE_DATA_UTIL.getAverageNumberOfRequestsInTheSystem(), 0.1);
    }

    @Test
    public void testGetAverageTimeInQueue() {
        assertEquals(0.000002, PERFORMANCE_DATA_UTIL.getAverageTimeInQueue(), 0.000001);
    }

    @Test
    public void testGetAverageTimeInSystem() {
        assertEquals(0.04, PERFORMANCE_DATA_UTIL.getAverageTimeInSystem(), 0.1);
    }
}