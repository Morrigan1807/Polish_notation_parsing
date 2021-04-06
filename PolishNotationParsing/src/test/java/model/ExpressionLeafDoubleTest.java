package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionLeafDoubleTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/TestExpressionLeafDouble/testDataGetResultOfExpression.csv")
    public void testGetResultOfExpression(double input, double expected) {
        ExpressionLeafDouble expressionLeafDouble = new ExpressionLeafDouble(input);

        assertEquals(expected, expressionLeafDouble.getResultOfExpression(), 0.01);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/TestExpressionLeafDouble/testDataGetStringOfPolishNotation.csv")
    public void testGetStringOfPolishNotation(double input, String expected) {
        ExpressionLeafDouble expressionLeafDouble = new ExpressionLeafDouble(input);

        assertEquals(expected, expressionLeafDouble.getStringOfPolishNotation());
    }
}