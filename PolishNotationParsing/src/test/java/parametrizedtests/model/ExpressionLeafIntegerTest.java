package parametrizedtests.model;

import model.ExpressionLeafInteger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.Constant.*;

public class ExpressionLeafIntegerTest {

    @ParameterizedTest
    @CsvFileSource(resources = PATH_TO_EXPRESSION_LEAF_INTEGER_TEST_DATA + TEST_DATA_GET_RESULT_OF_EXPRESSION)
    public void testGetResultOfExpression(int input, int expected) {
        assertEquals(expected, new ExpressionLeafInteger(input).getResultOfExpression());
    }

    @ParameterizedTest
    @CsvFileSource(resources = PATH_TO_EXPRESSION_LEAF_INTEGER_TEST_DATA + TEST_DATA_GET_STRING_OF_POLISH_NOTATION)
    public void testGetStringOfPolishNotation(int input, String expected) {
        assertEquals(expected, new ExpressionLeafInteger(input).getStringOfPolishNotation());
    }
}