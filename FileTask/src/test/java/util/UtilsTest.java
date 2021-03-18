package util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

    @Test
    void testRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonal() {
        List<List<Integer>> firstInputMatrixForTest = new ArrayList<>();
        firstInputMatrixForTest.add(Arrays.asList(3, 3, 0));
        firstInputMatrixForTest.add(Arrays.asList(2, 0, 2));
        firstInputMatrixForTest.add(Arrays.asList(0, 1, 1));

        List<List<Integer>> firstExpectedMatrix = new ArrayList<>();
        firstExpectedMatrix.add(Arrays.asList(0, 1, 1));
        firstExpectedMatrix.add(Arrays.asList(2, 0, 2));
        firstExpectedMatrix.add(Arrays.asList(3, 3, 0));

        Utils.rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonal(firstInputMatrixForTest);

        assertEquals(firstExpectedMatrix, firstInputMatrixForTest);

        List<List<Integer>> secondInputMatrixForTest = new ArrayList<>();
        secondInputMatrixForTest.add(Arrays.asList(-2, 0, -2));
        secondInputMatrixForTest.add(Arrays.asList(-3, -3, 0));
        secondInputMatrixForTest.add(Arrays.asList(0, -1, -1));

        List<List<Integer>> secondExpectedMatrix = new ArrayList<>();
        secondExpectedMatrix.add(Arrays.asList(0, -1, -1));
        secondExpectedMatrix.add(Arrays.asList(-2, 0, -2));
        secondExpectedMatrix.add(Arrays.asList(-3, -3, 0));

        Utils.rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonal(secondInputMatrixForTest);

        assertEquals(secondExpectedMatrix, secondInputMatrixForTest);
    }

    @Test
    void testCreateMatrixWithInfoFromString() {

        List<List<Integer>> firstExpectedMatrix = new ArrayList<>();
        firstExpectedMatrix.add(Arrays.asList(2, 0, 2));
        firstExpectedMatrix.add(Arrays.asList(3, 3, 0));
        firstExpectedMatrix.add(Arrays.asList(0, 1, 1));

        assertEquals(firstExpectedMatrix, Utils.createMatrixWithInfoFromString(Constant.DATA_FOR_TEST_CREATE_MATRIX_WITH_INFO_FROM_STRING_FIRST_MATRIX_INFO));

        List<List<Integer>> secondExpectedMatrix = new ArrayList<>();
        secondExpectedMatrix.add(Arrays.asList(-2, 0, -2));
        secondExpectedMatrix.add(Arrays.asList(-3, -3, 0));
        secondExpectedMatrix.add(Arrays.asList(0, -1, -1));

        assertEquals(secondExpectedMatrix, Utils.createMatrixWithInfoFromString(Constant.DATA_FOR_TEST_CREATE_MATRIX_WITH_INFO_FROM_STRING_SECOND_MATRIX_INFO));
    }
}