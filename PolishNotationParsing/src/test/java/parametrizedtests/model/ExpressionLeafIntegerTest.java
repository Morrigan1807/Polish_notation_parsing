package parametrizedtests.model;

import model.ExpressionLeafInteger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionLeafIntegerTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/test/testexpressionleafinteger/testDataGetResultOfExpression.csv")
    public void testGetResultOfExpression(int input, int expected) {
        ExpressionLeafInteger expressionLeafInteger = new ExpressionLeafInteger(input);

        assertEquals(expected, expressionLeafInteger.getResultOfExpression());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test/testexpressionleafinteger/testDataGetStringOfPolishNotation.csv")
    public void testGetStringOfPolishNotation(int input, String expected) {
        ExpressionLeafInteger expressionLeafInteger = new ExpressionLeafInteger(input);

        assertEquals(expected, expressionLeafInteger.getStringOfPolishNotation());
    }
}