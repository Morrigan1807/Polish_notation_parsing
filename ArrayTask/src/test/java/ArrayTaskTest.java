import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTaskTest {

    private int[] getArrayFromString(String stringFromCsv)
    {
        stringFromCsv = prepareStringToParsing(stringFromCsv);

        return parseString(stringFromCsv);
    }
    
    private int[] parseString(String stringFromCsv) {
        int[] res = new int[getSize(stringFromCsv) + 1];
        
        for (int i = 0; i < res.length - 1; i++)
        {
            res[i] = getNextIntInString(stringFromCsv);
            stringFromCsv = getSubstring(stringFromCsv);
        }

        res[res.length - 1] = Integer.parseInt(stringFromCsv);
        return res;
    }
    
    private String getSubstring(String stringFromCsv) {
        return stringFromCsv.substring(stringFromCsv.indexOf(";") + 1);
    }

    private int getNextIntInString(String stringFromCsv) {
        return Integer.parseInt(stringFromCsv.substring(0, stringFromCsv.indexOf(";")));
    }

    private int getSize(String stringFromCsv) {
        int size = 0;
        for (Character ch: stringFromCsv.toCharArray())
        {
            if (ch == ';')
            {
                size++;
            }
        }
        return size;
    }

    private String prepareStringToParsing(String stringFromCsv) {
        return stringFromCsv.replaceAll(" ", "");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "Test/testData_test_MaxMultiplicationInArray_AnyIntegersInArrayCase_ArrayTask.csv")
    public void test_MaxMultiplicationInArray_AnyIntegersInArrayCase(String inputStr, int expected) {
        int[] input = getArrayFromString(inputStr);

        assertEquals(expected, new ArrayTask().maxMultiplicationInArray(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "Test/testData_test_MaxMultiplicationInArray_PositiveIntegersInArrayCase_ArrayTask.csv")
    public void test_MaxMultiplicationInArray_PositiveIntegersInArrayCase(String inputStr, int expected) {
        int[] input = getArrayFromString(inputStr);

        assertEquals(expected, new ArrayTask().maxMultiplicationInArray(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "Test/testData_test_MaxMultiplicationInArray_NegativeIntegersInArrayCase_ArrayTask.csv")
    public void test_MaxMultiplicationInArray_NegativeIntegersInArrayCase(String inputStr, int expected) {
        int[] input = getArrayFromString(inputStr);

        assertEquals(expected, new ArrayTask().maxMultiplicationInArray(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "Test/testData_testMaxMultiplicationOfThree_ArrayTask_IncorrectCase.csv")
    public void testHasNoDuplicatesInStringIncorrectCase(String inputStr) {
        int[] input = getArrayFromString(inputStr);

        assertThrows(NegativeArraySizeException.class, ()->new ArrayTask().maxMultiplicationInArray(input));
    }
}