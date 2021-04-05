package util;

import model.*;

import static util.Constant.OPERATOR_NOT_FOUND;

public class Util {

    public static ExpressionTree parseStringToExpressionTree(String expression) {
        if (isSignedDoubleNumber(expression)) {
            return new ExpressionLeafDouble(Double.parseDouble(expression));
        } else if (isSignedIntegerNumber(expression)) {
            return new ExpressionLeafInteger(Integer.parseInt(expression));
        } else {
            expression = getStringWithoutExtraParentheses(expression);
            int index = getNextOperatorPosition(expression);

            return getExpressionNode(expression, index);
        }
    }

    public static String removeSpaces(String stringForSpaceRemoving) {
        return stringForSpaceRemoving.replaceAll(" ", "");
    }

    public static boolean isCorrectParentheses(String expression) {
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

    public static boolean isIncorrectInputExpression(String inputExpression) {
        return inputExpression.matches(".*([+\\-*/][+\\-*/]|[+\\-*/]\\)|\\([*/]|[^0-9][.,]|[.,][^0-9]|\\(\\)).*|.*[+\\-*/.,]|[*/.,].*") ||
                inputExpression.matches("[^+\\-*/0-9.,()]");
    }

    private static ExpressionNode getExpressionNode(String expression, int index) {
        ExpressionNode node = new ExpressionNode();

        node.setRootOperator(OperatorModel.fromString(expression.substring(index, index + 1)));

        node.setLeftOperand(parseStringToExpressionTree(expression.substring(0, index)));
        node.setRightOperand(parseStringToExpressionTree(expression.substring(index + 1)));
        return node;
    }

    private static String getStringWithoutExtraParentheses(String expression) {
        while (expression.charAt(0) == '(' && expression.charAt(expression.length() - 1) == ')' &&
                isCorrectParentheses(expression.substring(1, expression.length() - 1))) {
            expression = expression.substring(1, expression.length() - 1);
        }
        return expression;
    }

    private static boolean isSignedIntegerNumber(String expression) {
        return expression.matches("^[-+]?[0-9]+$");
    }

    private static boolean isSignedDoubleNumber(String expression) {
        return expression.matches("^[-+]?[0-9]+[.,][0-9]+$");
    }

    private static int getNextOperatorPosition(String expression) {
        Integer i1 = getNextPlusOrMinusOperatorPosition(expression);
        if (i1 != null) {
            return i1;
        }
        Integer i2 = getNextMultiplyOperatorPosition(expression);
        if (i2 != null) {
            return i2;
        }
        Integer i = getNextDivisionOperatorPosition(expression);
        if (i != null) {
            return i;
        }

        throw new IllegalArgumentException(OPERATOR_NOT_FOUND);
    }

    private static Integer getNextDivisionOperatorPosition(String expression) {
        int count;
        int i;

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
        return null;
    }

    private static Integer getNextMultiplyOperatorPosition(String expression) {
        int count;
        int i;

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
        return null;
    }

    private static Integer getNextPlusOrMinusOperatorPosition(String expression) {
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
        return null;
    }
}
