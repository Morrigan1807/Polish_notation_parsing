package model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BusDepot {

    private List<Bus> buses = new ArrayList<>();
    private List<Thread> threads = new ArrayList<>();

    public void startWorking() {
        for (Bus bus : buses) {
            threads.add(new Thread(bus));
            threads.get(threads.size() - 1).start();
        }
    }
}
