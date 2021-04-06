package parametrizedtests.model;

import model.ExpressionLeafDouble;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.Constant.*;

public class ExpressionLeafDoubleTest {

    @ParameterizedTest
    @CsvFileSource(resources = PATH_TO_EXPRESSION_LEAF_DOUBLE_TEST_DATA + TEST_DATA_GET_RESULT_OF_EXPRESSION)
    public void testGetResultOfExpression(double input, double expected) {
        assertEquals(expected, new ExpressionLeafDouble(input).getResultOfExpression(), 0.01);
    }

    @ParameterizedTest
    @CsvFileSource(resources = PATH_TO_EXPRESSION_LEAF_DOUBLE_TEST_DATA + TEST_DATA_GET_STRING_OF_POLISH_NOTATION)
    public void testGetStringOfPolishNotation(double input, String expected) {
        assertEquals(expected, new ExpressionLeafDouble(input).getStringOfPolishNotation());
    }
}