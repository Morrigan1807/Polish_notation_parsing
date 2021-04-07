package parametrizedtests.model;

import model.ExpressionLeafInteger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.Constant.TEST_DATA_GET_RESULT_OF_EXPRESSION_INTEGER;
import static util.Constant.TEST_DATA_GET_STRING_OF_POLISH_NOTATION_INTEGER;

public class ExpressionLeafIntegerTest {

    @ParameterizedTest
    @CsvFileSource(resources = TEST_DATA_GET_RESULT_OF_EXPRESSION_INTEGER)
    public void testGetResultOfExpression(int input, int expected) {
        assertEquals(expected, new ExpressionLeafInteger(input).getResultOfExpression());
    }

    @ParameterizedTest
    @CsvFileSource(resources = TEST_DATA_GET_STRING_OF_POLISH_NOTATION_INTEGER)
    public void testGetStringOfPolishNotation(int input, String expected) {
        assertEquals(expected, new ExpressionLeafInteger(input).getStringOfPolishNotation());
    }
}