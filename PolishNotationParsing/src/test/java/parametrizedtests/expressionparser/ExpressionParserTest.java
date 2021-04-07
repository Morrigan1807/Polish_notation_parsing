package parametrizedtests.expressionparser;

import expressionparser.ExpressionParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;
import static util.Constant.*;

public class ExpressionParserTest {

    @ParameterizedTest
    @CsvFileSource(resources = TEST_DATA_GET_STRING_WITH_EXPRESSION_BY_POLISH_NOTATION)
    public void testGetStringWithExpressionByPolishNotation(String input, String expected) {
        assertEquals(expected, ExpressionParser.parseExpression(input).getStringWithExpressionByPolishNotation());
    }

    @ParameterizedTest
    @CsvFileSource(resources = TEST_DATA_GET_RESULT_OF_EXPRESSION_PARSER)
    public void testGetResultOfExpression(String input, double expected) {
        assertEquals(expected, ExpressionParser.parseExpression(input).getResultOfExpression(), 0.01);
    }

    @ParameterizedTest
    @CsvFileSource(resources = TEST_DATA_PARSE_EXPRESSION_CORRECT_CASE)
    public void testParseExpressionCorrectCase(String input) {
        assertDoesNotThrow(() -> ExpressionParser.parseExpression(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = TEST_DATA_PARSE_EXPRESSION_INCORRECT_CASE)
    public void testParseExpressionIncorrectCase(String input) {
        assertThrows(IllegalArgumentException.class, () -> ExpressionParser.parseExpression(input));
    }
}