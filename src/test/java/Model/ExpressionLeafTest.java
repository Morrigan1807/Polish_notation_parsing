package Model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionLeafTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/testData_Calculate_ExpressionLeaf.csv")
    public void testCalculate(double input, double expected) {
        ExpressionLeaf expressionLeaf = new ExpressionLeaf(input);

        assertEquals(expected, expressionLeaf.calculate(), 0.01);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData_toPolishNotation_ExpressionLeaf.csv")
    public void testToPolishNotation(double input, String expected) {
        ExpressionLeaf expressionLeaf = new ExpressionLeaf(input);

        assertEquals(expected, expressionLeaf.toPolishNotation());
    }
}