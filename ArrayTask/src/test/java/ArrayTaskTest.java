import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTaskTest {
    private final String resourceFileForTestMaxMultiplicationInArrayAnyIntegersInArrayCase =
            "Test/testData_test_MaxMultiplicationInArray_AnyIntegersInArrayCase_ArrayTask.csv";
    private final String resourceFileForTestMaxMultiplicationInArrayPositiveIntegersInArrayCase =
            "Test/testData_test_MaxMultiplicationInArray_PositiveIntegersInArrayCase_ArrayTask.csv";
    private final String resourceFileForTestMaxMultiplicationInArrayNegativeIntegersInArrayCase =
            "Test/testData_test_MaxMultiplicationInArray_NegativeIntegersInArrayCase_ArrayTask.csv";
    private final String resourceFileForTestHasNoDuplicatesInStringIncorrectCase =
            "Test/testData_testMaxMultiplicationOfThree_ArrayTask_IncorrectCase.csv";


    private int[] getArrayFromString(String stringFromCsv)
    {
        return parseIntArray(stringFromCsv.split("; "));
    }

    private int[] parseIntArray(String[] stringArray){
        int[] result = new int[stringArray.length];

        for(int i = 0; i < stringArray.length; i++)
        {
            result[i] = Integer.parseInt(stringArray[i]);
        }

        return result;
    }

    @ParameterizedTest
    @CsvFileSource(resources = resourceFileForTestMaxMultiplicationInArrayAnyIntegersInArrayCase)
    public void testMaxMultiplicationInArrayAnyIntegersInArrayCase(String inputStr, int expected) {
        int[] input = getArrayFromString(inputStr);

        assertEquals(expected, new ArrayTask().maxMultiplicationInArray(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = resourceFileForTestMaxMultiplicationInArrayPositiveIntegersInArrayCase)
    public void testMaxMultiplicationInArrayPositiveIntegersInArrayCase(String inputStr, int expected) {
        int[] input = getArrayFromString(inputStr);

        assertEquals(expected, new ArrayTask().maxMultiplicationInArray(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = resourceFileForTestMaxMultiplicationInArrayNegativeIntegersInArrayCase)
    public void testMaxMultiplicationInArrayNegativeIntegersInArrayCase(String inputStr, int expected) {
        int[] input = getArrayFromString(inputStr);

        assertEquals(expected, new ArrayTask().maxMultiplicationInArray(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = resourceFileForTestHasNoDuplicatesInStringIncorrectCase)
    public void testHasNoDuplicatesInStringIncorrectCase(String inputStr) {
        int[] input = getArrayFromString(inputStr);

        assertThrows(NegativeArraySizeException.class, ()->new ArrayTask().maxMultiplicationInArray(input));
    }
}