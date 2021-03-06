package model;

import java.util.ArrayList;
import java.util.List;

public class LoggerOfBusStops {

    private static List<String> logger;
    private static LoggerOfBusStops loggerOfBusStops = new LoggerOfBusStops();

    private LoggerOfBusStops() {
        logger = new ArrayList<>();
    }

    public static LoggerOfBusStops getInstance() {
        return loggerOfBusStops;
    }

    public void addInformationInLogger(String logInformation) {
        logger.add(logInformation);
    }

    @Override
    public String toString() {
        StringBuilder outputLog = new StringBuilder(logger.get(0));

        for (int i = 1; i < logger.size() - 1; i++) {
            outputLog.append("\n").append(logger.get(i));
        }

        return outputLog.toString();
    }

    public void clearLog() {
        logger.clear();
    }
}
