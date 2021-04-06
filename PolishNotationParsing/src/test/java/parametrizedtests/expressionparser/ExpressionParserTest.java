package parametrizedtests.expressionparser;

import expressionparser.ExpressionParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionParserTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/test/expressionparser/testDataGetStringWithExpressionByPolishNotation.csv")
    public void testGetStringWithExpressionByPolishNotation(String input, String expected) {
        ExpressionParser expressionParser = ExpressionParser.parseExpression(input);

        assertEquals(expected, expressionParser.getStringWithExpressionByPolishNotation());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test/expressionparser/testDataGetResultOfExpression.csv")
    public void testGetResultOfExpression(String input, double expected) {
        ExpressionParser expressionParser = ExpressionParser.parseExpression(input);

        assertEquals(expected, expressionParser.getResultOfExpression(), 0.01);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test/expressionparser/testDataParseExpressionCorrectCase.csv")
    public void testParseExpressionCorrectCase(String input) {
        assertDoesNotThrow(() -> ExpressionParser.parseExpression(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test/expressionparser/testDataParseExpressionIncorrectCase.csv")
    public void testParseExpressionIncorrectCase(String input) {
        assertThrows(IllegalArgumentException.class, () -> ExpressionParser.parseExpression(input));
    }
}