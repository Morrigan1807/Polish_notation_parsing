package model.shop;

import javafx.collections.ObservableList;
import model.database.InputShopDataModel;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Runnable {

    public List<CashWindow> cashWindows = new ArrayList<>();
    private InputShopDataModel inputShopDataModel;
    private ObservableList<String> logList;

    Shop(InputShopDataModel inputShopDataModel, ObservableList<String> logList) {
        this.inputShopDataModel = inputShopDataModel;
        this.logList = logList;
    }

    public double poisson() {
        return 1.1;
    }

    public void run() {

    }

    private Customer getNewCustomer() {
        return new Customer();
    }

    private void assignCustomerToQueue(Customer currentCustomer) {

    }

    private void increaseSpeed() {

    }
}
