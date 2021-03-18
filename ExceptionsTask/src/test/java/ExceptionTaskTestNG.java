import model.DivisionByZeroException;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExceptionTaskTestNG {

    @Test(expectedExceptions = {IndexOutOfBoundsException.class})
    public void testGenerateIndexOutOfBoundsException() throws IndexOutOfBoundsException {
        ExceptionTask.generateIndexOutOfBoundsException();
    }

    @Test(expectedExceptions = {IOException.class})
    public void testGenerateIOException() throws IOException {
        ExceptionTask.generateIOException();
    }

    @Test(expectedExceptions = {ArithmeticException.class})
    public void testGenerateArithmeticException() throws ArithmeticException {
        ExceptionTask.generateArithmeticException();
    }

    @Test(expectedExceptions = {DivisionByZeroException.class}, expectedExceptionsMessageRegExp = "Some cool message")
    public void testGenerateDivisionByZeroException() throws DivisionByZeroException {
        ExceptionTask.generateDivisionByZeroException("Some cool message");
    }
}