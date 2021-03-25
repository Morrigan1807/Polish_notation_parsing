package util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTest {

    @Test
    public void testRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalWithPositiveNumbersCase() {
        List<List<Integer>> inputMatrixForTest = new ArrayList<>();
        inputMatrixForTest.add(Arrays.asList(3, 3, 0));
        inputMatrixForTest.add(Arrays.asList(2, 0, 2));
        inputMatrixForTest.add(Arrays.asList(0, 1, 1));

        List<List<Integer>> expectedMatrix = Arrays.asList(
                Arrays.asList(0, 1, 1),
                Arrays.asList(2, 0, 2),
                Arrays.asList(3, 3, 0));

        Utils.rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonal(inputMatrixForTest);

        assertEquals(expectedMatrix, inputMatrixForTest);
    }

    @Test
    public void testRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalWithNegativeNumbersCase() {
        List<List<Integer>> inputMatrixForTest = new ArrayList<>();
        inputMatrixForTest.add(Arrays.asList(-2, 0, -2));
        inputMatrixForTest.add(Arrays.asList(-3, -3, 0));
        inputMatrixForTest.add(Arrays.asList(0, -1, -1));

        List<List<Integer>> expectedMatrix = Arrays.asList(
                Arrays.asList(0, -1, -1),
                Arrays.asList(-2, 0, -2),
                Arrays.asList(-3, -3, 0));

        Utils.rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonal(inputMatrixForTest);

        assertEquals(expectedMatrix, inputMatrixForTest);
    }

    @Test
    public void testCreateMatrixWithInfoFromStringWithPositiveNumbersCase() {
        List<List<Integer>> expectedMatrix = Arrays.asList(
                Arrays.asList(2, 0, 2),
                Arrays.asList(3, 3, 0),
                Arrays.asList(0, 1, 1));

        assertEquals(expectedMatrix, Utils.getMatrixWithInformationFromString(
                Constant.STRING_WITH_UNCONVERTED_POSITIVE_MATRIX_DATA));
    }

    @Test
    public void testCreateMatrixWithInfoFromStringWithNegativeNumbersCase() {
        List<List<Integer>> expectedMatrix = Arrays.asList(
                Arrays.asList(-2, 0, -2),
                Arrays.asList(-3, -3, 0),
                Arrays.asList(0, -1, -1));

        assertEquals(expectedMatrix, Utils.getMatrixWithInformationFromString(
                Constant.STRING_WITH_UNCONVERTED_NEGATIVE_MATRIX_DATA));
    }
}