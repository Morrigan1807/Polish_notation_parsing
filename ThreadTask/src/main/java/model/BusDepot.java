package model;

import lombok.Data;

import java.util.List;

@Data
public class BusDepot {
    private List<Bus> buses;

    public void startWorking() {
        for (Bus bus : buses) {
            Thread thread = new Thread(bus);
            thread.start();
        }
    }
}
