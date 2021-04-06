package expressionparser;

import ParameterizedTests.model.ExpressionTree;

import static util.Util.*;

public class ExpressionParser {

    private final ExpressionTree expressionTree;

    private ExpressionParser(ExpressionTree expressionTree) {
        this.expressionTree = expressionTree;
    }

    public static ExpressionParser parseExpression(String inputExpression) {
        String expressionWithoutSpaces = removeSpaces(inputExpression);

        checkCorrectParentheses(expressionWithoutSpaces);
        checkExpressionArithmeticallyCorrect(expressionWithoutSpaces);

        return new ExpressionParser(parseStringToExpressionTree(expressionWithoutSpaces));
    }

    public String getStringWithExpressionByPolishNotation() {
        return expressionTree.getStringOfPolishNotation();
    }

    public double getResultOfExpression() {
        return expressionTree.getResultOfExpression();
    }
}
