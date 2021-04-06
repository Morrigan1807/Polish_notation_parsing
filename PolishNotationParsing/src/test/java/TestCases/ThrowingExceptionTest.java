package TestCases;

import expressionparser.ExpressionParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ThrowingExceptionTest {

    @Test
    public void testThrowIllegalArgumentExceptionWhenInputValueHigherThanMaximum() {
        assertThrows(IllegalArgumentException.class, () -> ExpressionParser.parseExpression("2 + 3 000 000 000"));
    }

    @Test
    public void testThrowIllegalArgumentExceptionWhenNotExpressionEntered() {
        assertThrows(IllegalArgumentException.class, () -> ExpressionParser.parseExpression("Hello world"));
    }

    @Test
    public void testThrowIllegalArgumentExceptionWhenInputIncorrectPositionOfParentheses() {
        assertThrows(IllegalArgumentException.class, () -> ExpressionParser.parseExpression("4 (/ 5)"));
    }

    @Test
    public void TestThrowArithmeticExceptionWhenExpressionHasDivisionByZero() {
        ExpressionParser expressionParser = ExpressionParser.parseExpression("13 / 0");

        assertThrows(ArithmeticException.class, expressionParser::getResultOfExpression);
    }
}
