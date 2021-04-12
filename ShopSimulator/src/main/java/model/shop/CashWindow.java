package model.shop;

import javafx.collections.ObservableList;
import model.database.InputShopDataModel;

import java.util.LinkedList;
import java.util.Queue;

public class CashWindow implements Runnable {

    private static int iteratorForNumber = 0;
    private Queue<Customer> queue = new LinkedList<>();
    private final int number;
    private InputShopDataModel inputShopDataModel;
    private ObservableList<String> logLost;
    private int customersInQueue = 0;

    public CashWindow(InputShopDataModel inputShopDataModel, ObservableList<String> logList) {
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
