package parametrizedtests.model;

import model.ExpressionLeafDouble;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.Constant.TEST_DATA_GET_RESULT_OF_EXPRESSION_DOUBLE;
import static util.Constant.TEST_DATA_GET_STRING_OF_POLISH_NOTATION_DOUBLE;

public class ExpressionLeafDoubleTest {

    @ParameterizedTest
    @CsvFileSource(resources = TEST_DATA_GET_RESULT_OF_EXPRESSION_DOUBLE)
    public void testGetResultOfExpression(double input, double expected) {
        assertEquals(expected, new ExpressionLeafDouble(input).getResultOfExpression(), 0.01);
    }

    @ParameterizedTest
    @CsvFileSource(resources = TEST_DATA_GET_STRING_OF_POLISH_NOTATION_DOUBLE)
    public void testGetStringOfPolishNotation(double input, String expected) {
        assertEquals(expected, new ExpressionLeafDouble(input).getStringOfPolishNotation());
    }
}