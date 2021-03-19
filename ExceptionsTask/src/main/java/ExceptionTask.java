import model.DivisionByZeroException;

import java.io.IOException;

public class ExceptionTask {

    public double calculateDivision(double dividend, double divider) throws DivisionByZeroException {
        if (divider == 0) {
            throw new DivisionByZeroException();
        }

        return dividend / divider;
    }

    public void generateIndexOutOfBoundsException() {
        throw new IndexOutOfBoundsException();
    }

    public void generateIOException() throws IOException {
        throw new IOException();
    }

    public void generateArithmeticException() {
        throw new ArithmeticException("Amazing message!");
    }

    public void generateDivisionByZeroException(String message) throws DivisionByZeroException {
        throw new DivisionByZeroException(message, 11);
    }

    public void exceptionHandling() {
        try {
            generateIndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            int a = 5;
        }
    }
}
