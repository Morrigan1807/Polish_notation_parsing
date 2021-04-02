package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO to refactor
public class ExpressionLeafIntegerTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/TestExpressionLeafInteger/testData_Calculate_ExpressionLeafInteger.csv")
    public void testCalculate(int input, int expected) {
        ExpressionLeafInteger expressionLeafInteger = new ExpressionLeafInteger(input);

        assertEquals(expected, expressionLeafInteger.calculate());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/TestExpressionLeafInteger/testData_toPolishNotation_ExpressionLeafInteger.csv")
    public void testToPolishNotation(int input, String expected) {
        ExpressionLeafInteger expressionLeafInteger = new ExpressionLeafInteger(input);

        assertEquals(expected, expressionLeafInteger.toPolishNotation());
    }
}