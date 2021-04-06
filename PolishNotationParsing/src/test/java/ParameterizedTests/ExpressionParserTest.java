package ParameterizedTests;

import expressionparser.ExpressionParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionParserTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/ExpressionParser/testDataGetStringWithExpressionByPolishNotation.csv")
    public void testGetStringWithExpressionByPolishNotation(String input, String expected) {
        ExpressionParser expressionParser = ExpressionParser.parseExpression(input);

        assertEquals(expected, expressionParser.getStringWithExpressionByPolishNotation());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/ExpressionParser/testDataGetResultOfExpression.csv")
    public void testGetResultOfExpression(String input, double expected) {
        ExpressionParser expressionParser = ExpressionParser.parseExpression(input);

        assertEquals(expected, expressionParser.getResultOfExpression(), 0.01);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/ExpressionParser/testDataParseExpressionCorrectCase.csv")
    public void testParseExpressionCorrectCase(String input) {
        assertDoesNotThrow(() -> ExpressionParser.parseExpression(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/ExpressionParser/testDataParseExpressionIncorrectCase.csv")
    public void testParseExpressionIncorrectCase(String input) {
        assertThrows(IllegalArgumentException.class, () -> ExpressionParser.parseExpression(input));
    }
}