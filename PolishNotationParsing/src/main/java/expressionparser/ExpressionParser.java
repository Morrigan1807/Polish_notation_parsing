package expressionparser;

import model.ExpressionTree;

import static util.Constant.ILLEGAL_INPUT;
import static util.Constant.INCORRECT_PARENTHESES_PLACEMENT;
import static util.Util.*;

public class ExpressionParser {

    private final ExpressionTree expressionTree;

    private ExpressionParser(ExpressionTree expressionTree) {
        this.expressionTree = expressionTree;
    }

    public static ExpressionParser parseExpression(String inputExpression) {
        inputExpression = removeSpaces(inputExpression);

        if (!isCorrectParentheses(inputExpression)) {
            throw new IllegalArgumentException(INCORRECT_PARENTHESES_PLACEMENT);
        }

        if (isIncorrectInputExpression(inputExpression)) {
            throw new IllegalArgumentException(ILLEGAL_INPUT);
        }

        return new ExpressionParser(parseStringToExpressionTree(inputExpression));
    }

    public String getStringWithExpressionByPolishNotation() {
        return expressionTree.getStringOfPolishNotation();
    }

    public double getResultOfExpression() {
        return expressionTree.getResultOfExpression();
    }
}
