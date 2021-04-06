package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionLeafDoubleTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/TestExpressionLeafDouble/testData_Calculate_ExpressionLeafDouble.csv")
    public void testCalculate(double input, double expected) {
        ExpressionLeafDouble expressionLeafDouble = new ExpressionLeafDouble(input);

        assertEquals(expected, expressionLeafDouble.calculate(), 0.01);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/TestExpressionLeafDouble/testData_toPolishNotation_ExpressionLeafDouble.csv")
    public void testToPolishNotation(double input, String expected) {
        ExpressionLeafDouble expressionLeafDouble = new ExpressionLeafDouble(input);

        assertEquals(expected, expressionLeafDouble.toPolishNotation());
    }
}