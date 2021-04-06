package util;

public class Constant {
    public static final char DIVISION_AS_CHAR = '/';
    public static final char MULTIPLICATION_AS_CHAR = '*';
    public static final char ADDITION_AS_CHAR = '+';
    public static final char SUBTRACTION_AS_CHAR = '-';
    public static final char LEFT_PARENTHESIS = '(';
    public static final char RIGHT_PARENTHESIS = ')';
    public static final String INCORRECT_PARENTHESES_PLACEMENT = "Incorrect parentheses placement.";
    public static final String ILLEGAL_INPUT = "Illegal input.";
    public static final String OPERATOR_NOT_FOUND = "Operator not found.";
    public static final String WRONG_OPERATOR_TYPE = "Wong operator type.";
    public static final String NOT_AN_OPERATOR = "Not an operator: ";
    public static final String TWO_CONSECUTIVE_OPERATORS_PATTERN = ".*[+\\-*/][+\\-*/].*";
    public static final String OPERATOR_FOLLOWED_BY_PARENTHESIS_PATTERN = ".*[+\\-*/]\\).*";
    public static final String PARENTHESIS_FOLLOWED_BY_MULTIPLICATION_OR_DIVISION_PATTERN = ".*\\([*/].*";
    public static final String NOT_NUMBER_FOLLOWED_BY_DECIMAL_SEPARATOR_PATTERN = ".*[^0-9][.,].*";
    public static final String DECIMAL_SEPARATOR_FOLLOWED_BY_NOT_NUMBER_PATTERN = ".*[.,][^0-9].*";
    public static final String EMPTY_PARENTHESES_PATTERN = ".*\\(\\).*";
    public static final String ENDING_WITH_OPERATOR_OR_DECIMAL_SEPARATOR_PATTERN = ".*[+\\-*/.,]";
    public static final String STARTING_WITH_OPERATOR_OR_DECIMAL_SEPARATOR_PATTERN = "[*/.,].*";
    public static final String HAS_NON_ARITHMETIC_CHARACTERS_PATTERN = ".*[^+\\-*/0-9.,()].*";
    public static final String SPACE = " ";
    public static final String EMPTY_STRING = "";
    public static final String SINGED_INTEGER_PATTERN = "^[-+]?[0-9]+$";
    public static final String SINGED_DOUBLE_PATTERN = "^[-+]?[0-9]+[.,][0-9]+$";
    public static final String DIVISION_AS_STRING = "/";
    public static final String MULTIPLICATION_AS_STRING = "*";
    public static final String ADDITION_AS_STRING = "+";
    public static final String SUBTRACTION_AS_STRING = "-";
}
