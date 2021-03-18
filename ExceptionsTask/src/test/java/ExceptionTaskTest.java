import model.DivisionByZeroException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionTaskTest {

    public static final String resourceFileForTestCalculateDivisionForDivisionByZeroExceptionGenerateExceptionCase =
            "testDataTestCalculateDivisionForDivisionByZeroExceptionGenerateExceptionCase.csv";
    public static final String resourceFileForTestCalculateDivisionForDivisionByZeroExceptionCorrectDividerCase =
            "testDataTestCalculateDivisionForDivisionByZeroExceptionCorrectDividerCase.csv";

    @ParameterizedTest
    @CsvFileSource(resources = resourceFileForTestCalculateDivisionForDivisionByZeroExceptionGenerateExceptionCase)
    public void testCalculateDivisionForDivisionByZeroExceptionGenerateExceptionCase(double dividend, double divider) {
        assertThrows(DivisionByZeroException.class, ()-> ExceptionTask.calculateDivision(dividend, divider));
    }

    @ParameterizedTest
    @CsvFileSource(resources = resourceFileForTestCalculateDivisionForDivisionByZeroExceptionCorrectDividerCase)
    public void testCalculateDivisionForDivisionByZeroExceptionCorrectDividerCase
            (double dividend, double divider, double expectedResult) throws DivisionByZeroException {
        assertEquals(expectedResult, ExceptionTask.calculateDivision(dividend, divider), 0.01);
    }
}