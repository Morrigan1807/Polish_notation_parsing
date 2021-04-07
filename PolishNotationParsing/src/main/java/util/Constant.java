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
    public static final String DIVISION_BY_ZERO = "Division by zero.";
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
    private static final String PATH_TO_EXPRESSION_PARSER_TEST_DATA = "/expressionparser/";
    public static final String TEST_DATA_GET_STRING_WITH_EXPRESSION_BY_POLISH_NOTATION =
            PATH_TO_EXPRESSION_PARSER_TEST_DATA + "testDataGetStringWithExpressionByPolishNotation.csv";
    public static final String TEST_DATA_GET_RESULT_OF_EXPRESSION_PARSER =
            PATH_TO_EXPRESSION_PARSER_TEST_DATA + "testDataGetResultOfExpression.csv";
    public static final String TEST_DATA_PARSE_EXPRESSION_CORRECT_CASE =
            PATH_TO_EXPRESSION_PARSER_TEST_DATA + "testDataParseExpressionCorrectCase.csv";
    public static final String TEST_DATA_PARSE_EXPRESSION_INCORRECT_CASE =
            PATH_TO_EXPRESSION_PARSER_TEST_DATA + "testDataParseExpressionIncorrectCase.csv";
    private static final String PATH_TO_EXPRESSION_LEAF_DOUBLE_TEST_DATA = "/expressionleafdouble/";
    public static final String TEST_DATA_GET_RESULT_OF_EXPRESSION_DOUBLE =
            PATH_TO_EXPRESSION_LEAF_DOUBLE_TEST_DATA + "testDataGetResultOfExpression.csv";
    public static final String TEST_DATA_GET_STRING_OF_POLISH_NOTATION_DOUBLE =
            PATH_TO_EXPRESSION_LEAF_DOUBLE_TEST_DATA + "testDataGetStringOfPolishNotation.csv";
    private static final String PATH_TO_EXPRESSION_LEAF_INTEGER_TEST_DATA = "/expressionleafinteger/";
    public static final String TEST_DATA_GET_RESULT_OF_EXPRESSION_INTEGER =
            PATH_TO_EXPRESSION_LEAF_INTEGER_TEST_DATA + "testDataGetResultOfExpression.csv";
    public static final String TEST_DATA_GET_STRING_OF_POLISH_NOTATION_INTEGER =
            PATH_TO_EXPRESSION_LEAF_INTEGER_TEST_DATA + "testDataGetStringOfPolishNotation.csv";
    private static final String PATH_TO_EXPRESSION_NODE_TEST_DATA = "/expressionnode/";
    public static final String TEST_DATA_GET_RESULT_OF_EXPRESSION_NODE =
            PATH_TO_EXPRESSION_NODE_TEST_DATA + "testDataGetResultOfExpression.csv";
    public static final String TEST_DATA_GET_STRING_OF_POLISH_NOTATION_NODE =
            PATH_TO_EXPRESSION_NODE_TEST_DATA + "testDataGetStringOfPolishNotation.csv";
    private static final String PATH_TO_OPERATOR_MODEL_TEST_DATA = "/operatormodel/";
    public static final String TEST_DATA_FROM_STRING_CORRECT_CASE =
            PATH_TO_OPERATOR_MODEL_TEST_DATA + "testDataFromStringCorrectCase.csv";
    public static final String TEST_DATA_FROM_STRING_INCORRECT_CASE =
            PATH_TO_OPERATOR_MODEL_TEST_DATA + "testDataFromStringIncorrectCase.csv";

    private Constant() {
    }
}
