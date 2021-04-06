import exceptiontask.ExceptionTask;
import model.DivisionByZeroException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTaskTest {

    static final String resourceFileForTestCalculateDivisionForDivisionByZeroExceptionGenerateExceptionCase =
            "testDataTestCalculateDivisionForDivisionByZeroExceptionGenerateExceptionCase.csv";
    static final String resourceFileForTestCalculateDivisionForDivisionByZeroExceptionCorrectDividerCase =
            "testDataTestCalculateDivisionForDivisionByZeroExceptionCorrectDividerCase.csv";

    @ParameterizedTest
    @CsvFileSource(resources = resourceFileForTestCalculateDivisionForDivisionByZeroExceptionGenerateExceptionCase)
    public void testCalculateDivisionForDivisionByZeroExceptionGenerateExceptionCase(double dividend, double divider) {
        assertThrows(DivisionByZeroException.class, () -> new ExceptionTask().calculateDivision(dividend, divider));
    }

    @ParameterizedTest
    @CsvFileSource(resources = resourceFileForTestCalculateDivisionForDivisionByZeroExceptionCorrectDividerCase)
    public void testCalculateDivisionForDivisionByZeroExceptionCorrectDividerCase
            (double dividend, double divider, double expectedResult) throws DivisionByZeroException {
        assertEquals(expectedResult, new ExceptionTask().calculateDivision(dividend, divider), 0.01);
    }

    @Test
    public void testGenerateIndexOutOfBoundsException() throws IndexOutOfBoundsException {
        ExceptionTask exceptionTask = new ExceptionTask();

        assertThrows(IndexOutOfBoundsException.class, exceptionTask::generateIndexOutOfBoundsException);
    }

    @Test
    public void testGenerateIOException() {
        assertThrows(IOException.class, () -> new ExceptionTask().generateIOException());
    }

    @Test
    public void testGenerateArithmeticException() throws ArithmeticException {
        ExceptionTask exceptionTask = new ExceptionTask();

        assertThrows(ArithmeticException.class, exceptionTask::generateArithmeticException);
    }

    @Test
    public void testGenerateDivisionByZeroException() {
        assertThrows(DivisionByZeroException.class, () -> new ExceptionTask().generateDivisionByZeroException("Some cool message"));
    }
}