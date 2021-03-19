import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionParserTest {

    @ParameterizedTest
    @CsvFileSource(resources = "Test/ExpressionParser/testData_toPolishNotation_ExpressionParser.csv")
    void testToPolishNotation(String input, String expected) {
        ExpressionParser expressionParser = ExpressionParser.parseExpression(input);

        assertEquals(expected, expressionParser.toPolishNotation());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/ExpressionParser/testData_calculateExpression_ExpressionParser.csv")
    void testCalculateExpression(String input, double expected) {
        ExpressionParser expressionParser = ExpressionParser.parseExpression(input);

        assertEquals(expected, expressionParser.calculateExpression(), 0.01);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/ExpressionParser/testData_parseExpression_ExpressionParser_CorrectCase.csv")
    void testParseExpression_CorrectCase(String input) {
        assertDoesNotThrow(() -> ExpressionParser.parseExpression(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/ExpressionParser/testData_parseExpression_ExpressionParser_IncorrectCase.csv")
    void testParseExpression_IncorrectCase(String input) {
        assertThrows(IllegalArgumentException.class, () -> ExpressionParser.parseExpression(input));
    }
}