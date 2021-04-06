package expressionparser;

import model.*;

public class ExpressionParser {

    private final ExpressionTree expressionTree;

    private ExpressionParser(ExpressionTree expressionTree) {
        this.expressionTree = expressionTree;
    }

    public static ExpressionParser parseExpression(String inputExpression) {
        inputExpression = removeSpaces(inputExpression);

        if (!isCorrectParentheses(inputExpression)) {
            throw new IllegalArgumentException("Incorrect parentheses placement.");
        }

        if (inputExpression.matches(".*([+\\-*/][+\\-*/]|[+\\-*/]\\)|\\([*/]|[^0-9][.,]|[.,][^0-9]|\\(\\)).*|.*[+\\-*/.,]|[*/.,].*") ||
                inputExpression.matches("[^+\\-*/0-9.,()]")) {
            throw new IllegalArgumentException("Illegal input.");
        }

        return new ExpressionParser(parseStringToExpressionTree(inputExpression));
    }

    private static ExpressionTree parseStringToExpressionTree(String expression) {
        if (expression.matches("^[-+]?[0-9]+[.,][0-9]+$")) {
            return new ExpressionLeafDouble(Double.parseDouble(expression));
        } else if (expression.matches("^[-+]?[0-9]+$")) {
            return new ExpressionLeafInteger(Integer.parseInt(expression));
        } else {
            while (expression.charAt(0) == '(' && expression.charAt(expression.length() - 1) == ')' &&
                    isCorrectParentheses(expression.substring(1, expression.length() - 1))) {
                expression = expression.substring(1, expression.length() - 1);
            }

            int index = getNextOperatorPosition(expression);

            ExpressionNode node = new ExpressionNode();

            node.setRootOperator(OperatorModel.fromString(expression.substring(index, index + 1)));

            node.setLeftOperand(parseStringToExpressionTree(expression.substring(0, index)));
            node.setRightOperand(parseStringToExpressionTree(expression.substring(index + 1)));

            return node;
        }
    }

    private static int getNextOperatorPosition(String expression) {
        int count = 0;
        int i = 0;

        for (char ch : expression.toCharArray()) {
            switch (ch) {
                case '(':
                    count++;
                    break;
                case ')':
                    count--;
                    break;
                case '+':
                case '-':
                    if (count == 0 && i != 0) {
                        return i;
                    }
                    break;
            }
            i++;
        }

        i = 0;
        count = 0;
        for (char ch : expression.toCharArray()) {
            switch (ch) {
                case '(':
                    count++;
                    break;
                case ')':
                    count--;
                    break;
                case '*':
                    if (count == 0) {
                        return i;
                    }
                    break;
            }
            i++;
        }

        i = 0;
        count = 0;
        for (char ch : expression.toCharArray()) {
            switch (ch) {
                case '(':
                    count++;
                    break;
                case ')':
                    count--;
                    break;
                case '/':
                    if (count == 0) {
                        return i;
                    }
                    break;
            }
            i++;
        }

        throw new IllegalArgumentException("Operator not found.");
    }

    private static String removeSpaces(String string) {
        return string.replaceAll(" ", "");
    }

    private static boolean isCorrectParentheses(String expression) {
        int count = 0;

        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;

                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }

    public String toPolishNotation() {
        return expressionTree.toPolishNotation();
    }

    public double calculateExpression() {
        return expressionTree.calculate();
    }
}
