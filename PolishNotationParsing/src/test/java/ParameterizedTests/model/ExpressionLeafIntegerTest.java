package ParameterizedTests.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionLeafIntegerTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/TestExpressionLeafInteger/testDataGetResultOfExpression.csv")
    public void testGetResultOfExpression(int input, int expected) {
        ExpressionLeafInteger expressionLeafInteger = new ExpressionLeafInteger(input);

        assertEquals(expected, expressionLeafInteger.getResultOfExpression());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/TestExpressionLeafInteger/testDataGetStringOfPolishNotation.csv")
    public void testGetStringOfPolishNotation(int input, String expected) {
        ExpressionLeafInteger expressionLeafInteger = new ExpressionLeafInteger(input);

        assertEquals(expected, expressionLeafInteger.getStringOfPolishNotation());
    }
}