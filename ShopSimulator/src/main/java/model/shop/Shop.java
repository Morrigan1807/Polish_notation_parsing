package model.shop;

import model.database.InputShopDataModel;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Runnable {

    public List<CashWindow> cashWindows = new ArrayList<>();
    private InputShopDataModel inputShopDataModel;
    private List<String> logList;

    public Shop(InputShopDataModel inputShopDataModel, List<String> logList) {
        this.inputShopDataModel = inputShopDataModel;
        this.logList = logList;
    }

    public double poisson() {
        //TODO Add Poisson for generating new customer
        return 1.1;
    }

    public void run() {
        //TODO Add work for shop simulation
    }

    private Customer getNewCustomer() {
        //TODO Add poisson for generating new customer
        return new Customer();
    }

    private void assignCustomerToQueue(Customer currentCustomer) {
        //TODO Add the ability / inability to queue up
    }

    private void increaseSpeed() {
        //TODO Add a reduction in simulation time depending on the set speed
    }
}
