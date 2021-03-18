import model.DivisionByZeroException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ExceptionTask {

    public static double calculateDivision(double dividend, double divider) throws DivisionByZeroException {
        if (divider == 0) {
            throw new DivisionByZeroException();
        }

        return dividend / divider;
    }

    public static void generateIndexOutOfBoundsException() {
        int[] n = new int[]{0, 1, 2, 3, 4};

        int a = n[5];
    }

    public static void generateIOException() throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(""));
        outputStreamWriter.write('c');
    }

    public static void generateArithmeticException() {
        throw new ArithmeticException("Amazing message!");
    }

    public static void generateDivisionByZeroException(String message) throws DivisionByZeroException {
        throw new DivisionByZeroException(message, 11);
    }
}
