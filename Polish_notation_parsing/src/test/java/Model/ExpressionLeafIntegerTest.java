package Model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionLeafIntegerTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/TestExpressionLeafInteger/testData_Calculate_ExpressionLeafInteger.csv")
    void testCalculate(int input, int expected) {
        ExpressionLeafInteger expressionLeafInteger = new ExpressionLeafInteger(input);

        assertEquals(expected, expressionLeafInteger.calculate());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/TestExpressionLeafInteger/testData_toPolishNotation_ExpressionLeafInteger.csv")
    void testToPolishNotation(int input, String expected) {
        ExpressionLeafInteger expressionLeafInteger = new ExpressionLeafInteger(input);

        assertEquals(expected, expressionLeafInteger.toPolishNotation());
    }
}