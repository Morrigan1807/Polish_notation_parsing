package model.shop;

import model.database.InputShopDataModel;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CashWindow implements Runnable {

    private static int iteratorForNumber = 0;
    private final int number;
    private Queue<Customer> queue = new LinkedList<>();
    private InputShopDataModel inputShopDataModel;
    private List<String> logLost;
    private int customersInQueue = 0;

    public CashWindow(InputShopDataModel inputShopDataModel, List<String> logList) {
        this.inputShopDataModel = inputShopDataModel;
        this.logLost = logList;
        number = ++iteratorForNumber;
    }

    private double poisson() {
        return 1.1;
    }

    public void run() {

    }
}
