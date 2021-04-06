package util;

import model.*;

import static util.Constant.*;

public class Util {

    public static ExpressionTree parseStringToExpressionTree(String expression) {
        if (isSignedDoubleNumber(expression)) {
            return new ExpressionLeafDouble(Double.parseDouble(expression));
        } else if (isSignedIntegerNumber(expression)) {
            return new ExpressionLeafInteger(Integer.parseInt(expression));
        } else {
            String expressionWithoutExtraParentheses = getStringWithoutExtraParentheses(expression);
            int index = getNextOperatorPosition(expressionWithoutExtraParentheses);

            return getExpressionNode(expressionWithoutExtraParentheses, index);
        }
    }

    public static String removeSpaces(String stringForSpaceRemoving) {
        return stringForSpaceRemoving.replaceAll(SPACE, EMPTY_STRING);
    }

    public static boolean isCorrectParentheses(String expression) {
        int count = 0;

        for (char ch : expression.toCharArray()) {
            if (ch == LEFT_PARENTHESIS) {
                count++;
            } else if (ch == RIGHT_PARENTHESIS) {
                count--;

                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }

    public static boolean isInputExpressionIncorrect(String inputExpression) {
        return inputExpression.matches(TWO_CONSECUTIVE_OPERATORS_PATTERN) ||
                inputExpression.matches(OPERATOR_FOLLOWED_BY_PARENTHESIS_PATTERN) ||
                inputExpression.matches(PARENTHESIS_FOLLOWED_BY_MULTIPLICATION_OR_DIVISION_PATTERN) ||
                inputExpression.matches(NOT_NUMBER_FOLLOWED_BY_DECIMAL_SEPARATOR_PATTERN) ||
                inputExpression.matches(DECIMAL_SEPARATOR_FOLLOWED_BY_NOT_NUMBER_PATTERN) ||
                inputExpression.matches(EMPTY_PARENTHESES_PATTERN) ||
                inputExpression.matches(ENDING_WITH_OPERATOR_OR_DECIMAL_SEPARATOR_PATTERN) ||
                inputExpression.matches(STARTING_WITH_OPERATOR_OR_DECIMAL_SEPARATOR_PATTERN) ||
                inputExpression.matches(HAS_NON_ARITHMETIC_CHARACTERS_PATTERN);
    }

    public static void checkCorrectParentheses(String expressionWithoutSpaces) {
        if (!isCorrectParentheses(expressionWithoutSpaces)) {
            throw new IllegalArgumentException(INCORRECT_PARENTHESES_PLACEMENT);
        }
    }

    public static void checkExpressionArithmeticallyCorrect(String expressionWithoutSpaces) {
        if (isInputExpressionIncorrect(expressionWithoutSpaces)) {
            throw new IllegalArgumentException(ILLEGAL_INPUT);
        }
    }

    private static ExpressionNode getExpressionNode(String expression, int index) {
        ExpressionNode node = new ExpressionNode();

        node.setRootOperator(OperatorModel.fromString(expression.substring(index, index + 1)));

        node.setLeftOperand(parseStringToExpressionTree(expression.substring(0, index)));
        node.setRightOperand(parseStringToExpressionTree(expression.substring(index + 1)));
        return node;
    }

    private static String getStringWithoutExtraParentheses(String expression) {
        String expressionWithoutExtraParentheses = expression;

        while (hasExtraParentheses(expressionWithoutExtraParentheses)) {
            expressionWithoutExtraParentheses = expressionWithoutExtraParentheses.substring(1, expressionWithoutExtraParentheses.length() - 1);
        }

        return expressionWithoutExtraParentheses;
    }

    private static boolean hasExtraParentheses(String expression) {
        return expression.charAt(0) == LEFT_PARENTHESIS && expression.charAt(expression.length() - 1) == RIGHT_PARENTHESIS &&
                isCorrectParentheses(expression.substring(1, expression.length() - 1));
    }

    private static boolean isSignedIntegerNumber(String expression) {
        return expression.matches(SINGED_INTEGER_PATTERN);
    }

    private static boolean isSignedDoubleNumber(String expression) {
        return expression.matches(SINGED_DOUBLE_PATTERN);
    }

    private static int getNextOperatorPosition(String expression) {
        int nextOperatorPosition = getNextPlusOrMinusOperatorPosition(expression);
        if (nextOperatorPosition != -1) {
            return nextOperatorPosition;
        }

        nextOperatorPosition = getNextMultiplyOperatorPosition(expression);
        if (nextOperatorPosition != -1) {
            return nextOperatorPosition;
        }

        nextOperatorPosition = getNextDivisionOperatorPosition(expression);
        if (nextOperatorPosition != -1) {
            return nextOperatorPosition;
        }

        throw new IllegalArgumentException(OPERATOR_NOT_FOUND);
    }

    private static int getNextDivisionOperatorPosition(String expression) {
        int count = 0;
        int currentPosition = 0;

        for (char charAtCurrentPosition : expression.toCharArray()) {
            switch (charAtCurrentPosition) {
                case LEFT_PARENTHESIS:
                    count++;
                    break;
                case RIGHT_PARENTHESIS:
                    count--;
                    break;
                case DIVISION_AS_CHAR:
                    if (count == 0) {
                        return currentPosition;
                    }
                    break;
                default:
                    break;
            }
            currentPosition++;
        }
        return -1;
    }

    private static int getNextMultiplyOperatorPosition(String expression) {
        int count = 0;
        int currentPosition = 0;

        for (char charAtCurrentPosition : expression.toCharArray()) {
            switch (charAtCurrentPosition) {
                case LEFT_PARENTHESIS:
                    count++;
                    break;
                case RIGHT_PARENTHESIS:
                    count--;
                    break;
                case MULTIPLICATION_AS_CHAR:
                    if (count == 0) {
                        return currentPosition;
                    }
                    break;
                default:
                    break;
            }
            currentPosition++;
        }
        return -1;
    }

    private static int getNextPlusOrMinusOperatorPosition(String expression) {
        int count = 0;
        int currentPosition = 0;

        for (char charAtCurrentPosition : expression.toCharArray()) {
            switch (charAtCurrentPosition) {
                case LEFT_PARENTHESIS:
                    count++;
                    break;
                case RIGHT_PARENTHESIS:
                    count--;
                    break;
                case ADDITION_AS_CHAR:
                case SUBTRACTION_AS_CHAR:
                    if (count == 0 && currentPosition != 0) {
                        return currentPosition;
                    }
                    break;
                default:
                    break;
            }
            currentPosition++;
        }
        return -1;
    }
}
