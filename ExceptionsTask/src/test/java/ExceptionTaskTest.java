import model.DivisionByZeroException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionTaskTest {

    public static final String resourceFileForTestCalculateDivisionForDivisionByZeroExceptionGenerateExceptionCase =
            "testDataTestCalculateDivisionForDivisionByZeroExceptionGenerateExceptionCase.csv";
    public static final String resourceFileForTestCalculateDivisionForDivisionByZeroExceptionCorrectDividerCase =
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
        assertThrows(IndexOutOfBoundsException.class, () -> new ExceptionTask().generateIndexOutOfBoundsException());
    }

    @Test
    public void testGenerateIOException() throws IOException {
        assertThrows(IOException.class, () -> new ExceptionTask().generateIOException());
    }

    @Test
    public void testGenerateArithmeticException() throws ArithmeticException {
        assertThrows(ArithmeticException.class, () -> new ExceptionTask().generateArithmeticException());
    }

    @Test
    public void testGenerateDivisionByZeroException() throws DivisionByZeroException {
        assertThrows(DivisionByZeroException.class, () -> new ExceptionTask().generateDivisionByZeroException("Some cool message"));
    }

    @Test
    void testExceptionHandling() {
        assertDoesNotThrow(()-> new ExceptionTask().exceptionHandling());
    }
}