package model.shop;

public class Customer {
    private static int iteratorForNumber = 0;
    private final int number;

    public Customer() {
        number = ++iteratorForNumber;
    }

    public int getNumber() {
        return number;
    }
}
