package TestCases;

import expressionparser.ExpressionParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranslatingComplexExpressionsTest {

    @Test
    public void testTranslatingIntoPolishNotationAndCalculatingExpressionWithOperationsEvaluatedNotInDirectOrder() {
        ExpressionParser expressionParser = ExpressionParser.parseExpression("2 + 3 - 7 * 4 / 4");

        assertEquals("2 3 7 4 4 / * - +", expressionParser.getStringWithExpressionByPolishNotation());
        assertEquals(-2, expressionParser.getResultOfExpression(), 0.01);
    }

    @Test
    public void testTranslatingIntoPolishNotationAndCalculatingComplexExpressionWithParentheses() {
        ExpressionParser expressionParser = ExpressionParser.parseExpression("2 * (4 - 21 / (18 - 11))");

        assertEquals("2 4 21 18 11 - / - *", expressionParser.getStringWithExpressionByPolishNotation());
        assertEquals(2, expressionParser.getResultOfExpression(), 0.01);
    }

    @Test
    public void testTranslatingIntoPolishNotationAndCalculatingExpressionWithDoubleResultOfCalculation() {
        ExpressionParser expressionParser = ExpressionParser.parseExpression("7 / 14");

        assertEquals("7 14 /", expressionParser.getStringWithExpressionByPolishNotation());
        assertEquals(0.5, expressionParser.getResultOfExpression(), 0.01);
    }

    @Test
    public void testTranslatingIntoPolishNotationAndCalculatingExpressionWithDoubleAndIntegersValues() {
        ExpressionParser expressionParser = ExpressionParser.parseExpression("100 * 0.74");

        assertEquals("100 0.74 *", expressionParser.getStringWithExpressionByPolishNotation());
        assertEquals(74, expressionParser.getResultOfExpression(), 0.01);
    }

    @Test
    public void testTranslatingIntoPolishNotationAndCalculatingExpressionWithNegativeAndPositiveValues() {
        ExpressionParser expressionParser = ExpressionParser.parseExpression("-200 + 20 * 2");

        assertEquals("-200 20 2 * +", expressionParser.getStringWithExpressionByPolishNotation());
        assertEquals(-160, expressionParser.getResultOfExpression(), 0.01);
    }

    @Test
    public void testTranslatingIntoPolishNotationAndCalculatingExpressionWhenInputValueNearMaximum() {
        ExpressionParser expressionParser = ExpressionParser.parseExpression("2 147 483 646 / 2");

        assertEquals("2147483646 2 /", expressionParser.getStringWithExpressionByPolishNotation());
        assertEquals(1073741823, expressionParser.getResultOfExpression(), 0.01);
    }

    @Test
    public void testTranslatingIntoPolishNotationAndCalculatingExpressionWithExtraParentheses() {
        ExpressionParser expressionParser = ExpressionParser.parseExpression("(((13 * 4)))");

        assertEquals("13 4 *", expressionParser.getStringWithExpressionByPolishNotation());
        assertEquals(52, expressionParser.getResultOfExpression(), 0.01);
    }

    @Test
    public void testTranslatingIntoPolishNotationAndCalculatingWithNegativeDoubleValue() {
        ExpressionParser expressionParser = ExpressionParser.parseExpression("2 * (-0.7)");

        assertEquals("2 -0.7 *", expressionParser.getStringWithExpressionByPolishNotation());
        assertEquals(-1.4, expressionParser.getResultOfExpression(), 0.01);
    }
}
