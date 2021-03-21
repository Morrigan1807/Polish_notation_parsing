package model;

public class DivisionByZeroException extends Exception {
    private final int number;

    public DivisionByZeroException() {
        super("Division by zero.");
        number = 0;
    }

    public DivisionByZeroException(String message, int num) {
        super(message);
        number = num;
    }

    //TODO code coverage this block
    public int getNumber() {
        return this.number;
    }
}

