package testcases;

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
        assertThrows(ArithmeticException.class, ExpressionParser.parseExpression("13 / 0")::getResultOfExpression);
    }
}
