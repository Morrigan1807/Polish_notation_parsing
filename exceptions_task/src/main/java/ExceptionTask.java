import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ExceptionTask {
    public static class DivisionByZeroException extends Exception
    {
        private final int number;

        public DivisionByZeroException()
        {
            super("Division by zero.");
            number = 0;
        }

        public DivisionByZeroException(String message, int num)
        {
            super(message);
            number = num;
        }

        public int getNumber() {
            return number;
        }
    }

    public static double calculateDivision(double dividend, double divider) throws DivisionByZeroException
    {
        if(divider == 0)
        {
            throw new DivisionByZeroException();
        }

        return dividend/divider;
    }

    public static void generateDivisionByZeroExceptionWithMessage() throws DivisionByZeroException {
            throw new DivisionByZeroException("Some message", 0);
    }

    private static void generateIndexOutOfBoundsException()
    {
        int[] n = new int[]{0, 1, 2, 3, 4};

        System.out.println(n[5]);
    }

    private static void generateIOException() throws IOException
    {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(""));
        outputStreamWriter.write('c');
    }

    private static void generateArithmeticException()
    {
        throw new ArithmeticException("Amazing message!");
    }

    private static void generateDivisionByZeroException() throws DivisionByZeroException
    {
        throw new DivisionByZeroException("Here new DivisionByZeroException!", 11);
    }

    public static void main(String[] args) {
        try
        {
            generateDivisionByZeroException();
            generateArithmeticException();
            generateIndexOutOfBoundsException();
            generateIOException();
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException)
        {
            System.out.println(indexOutOfBoundsException.toString());
        }
        catch (IOException ioException)
        {
            System.out.println("I'll never be here.\n" + ioException.toString());
        }
        catch (DivisionByZeroException divisionByZeroException)
        {
            System.out.println("Here my exception!\n" + divisionByZeroException.toString());
        }
        catch (Exception exc){
            System.out.println("Here will be any of exceptions.\n" + exc.toString());
        }
        finally {
            System.out.println("Anyway, the end.");
        }
    }
}
