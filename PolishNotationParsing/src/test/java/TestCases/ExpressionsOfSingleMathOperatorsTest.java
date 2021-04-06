package TestCases;

import expressionparser.ExpressionParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionsOfSingleMathOperatorsTest {

    @Test
    public void testTranslatingIntoPolishNotationAndCalculatingAdditionExpression() {
        ExpressionParser expressionParser = ExpressionParser.parseExpression("105 + 95");

        assertEquals("105 95 +", expressionParser.getStringWithExpressionByPolishNotation());
        assertEquals(200, expressionParser.getResultOfExpression(), 0.01);
    }

    @Test
    public void testTranslatingIntoPolishNotationAndCalculatingSubtractionExpression() {
        ExpressionParser expressionParser = ExpressionParser.parseExpression("105 - 95");

        assertEquals("105 95 -", expressionParser.getStringWithExpressionByPolishNotation());
        assertEquals(10, expressionParser.getResultOfExpression(), 0.01);
    }

    @Test
    public void testTranslatingIntoPolishNotationAndCalculatingMultiplicationExpression() {
        ExpressionParser expressionParser = ExpressionParser.parseExpression("105 * 2");

        assertEquals("105 2 *", expressionParser.getStringWithExpressionByPolishNotation());
        assertEquals(210, expressionParser.getResultOfExpression(), 0.01);
    }

    @Test
    public void testTranslatingIntoPolishNotationAndCalculatingDivisionExpression() {
        ExpressionParser expressionParser = ExpressionParser.parseExpression("105 / 5");

        assertEquals("105 5 /", expressionParser.getStringWithExpressionByPolishNotation());
        assertEquals(21, expressionParser.getResultOfExpression(), 0.01);
    }
}
