package util;

public class Constant {

    public static final String MESSAGE_FOR_ARRAY_STORE_EXCEPTION = "Cant find zero element for main diagonal.";
    public static final String MESSAGE_FOR_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION = "Matrix sizes do not match.";
    public static final String RESOURCE_FILE_FOR_TEST_REARRANGE_LINES_IN_MATRIX_FOR_ZERO_ELEMENTS_ON_THE_MAIN_DIAGONAL_IN_FILE_EXCEPTION_CASE =
            "filetask/testDataTestRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileNullPointerExceptionCaseFileTask.csv";
    public static final String RESOURCE_FILE_FOR_TEST_REARRANGE_LINES_IN_MATRIX_FOR_ZERO_ELEMENTS_ON_THE_MAIN_DIAGONAL_IN_FILE_CORRECT_INPUT_CASE =
            "filetask/testDataTestRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileCorrectInputCaseFileTask.csv";
    public static final String RESOURCE_FILE_FOR_TEST_REARRANGE_LINES_IN_MATRIX_FOR_ZERO_ELEMENTS_ON_THE_MAIN_DIAGONAL_IN_FILE_INCORRECT_SIZE_INPUT_CASE =
            "filetask/testDataTestRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileIncorrectSizeInputCase.csv";
    public static final String RESOURCE_FILE_FOR_TEST_REARRANGE_LINES_IN_MATRIX_FOR_ZERO_ELEMENTS_ON_THE_MAIN_DIAGONAL_IN_FILE_NUMBER_FORMAT_EXCEPTION_CASE =
            "filetask/testDataTestRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileNumberFormatExceptionCase.csv";
    public static final String SPACE = " ";
    public static final String REGEX_CARRIAGE_RETURN_CHARACTER_AND_LINE_FEED_CHARACTER_OR_LINE_FEED_CHARACTER_ONLY = "\r\n|\n";
    public static final String LINE_FEED_CHARACTER = "\n";
    public static final String TXT_EXTENSION = ".txt";
    public static final String STRING_WITH_UNCONVERTED_POSITIVE_MATRIX_DATA = "3 3\n2 0 2\n3 3 0\n0 1 1";
    public static final String STRING_WITH_UNCONVERTED_NEGATIVE_MATRIX_DATA = "3 3\n-2 0 -2\n-3 -3 0\n0 -1 -1";
    public static final String RESULT_WORK_FILE_NAME = "fileForRewriting.txt";
    public static final String FILE_NAME_WITH_EXTENSION = "hello.txt";
    public static final String FILE_NAME_WITHOUT_EXTENSION = "hello";
    public static final String FILE_NAME_WITH_EXPECTED_RESULT = "fileExp.txt";
    public static final String PATH_TO_RESOURCES = "src/main/resources/";


    private Constant() {
    }
}
