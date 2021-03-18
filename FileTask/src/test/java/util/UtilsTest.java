package util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        String firstMatrixInfo = "3 3\n2 0 2\n3 3 0\n0 1 1";

        List<List<Integer>> firstExpectedMatrix = new ArrayList<>();
        firstExpectedMatrix.add(Arrays.asList(2, 0, 2));
        firstExpectedMatrix.add(Arrays.asList(3, 3, 0));
        firstExpectedMatrix.add(Arrays.asList(0, 1, 1));

        assertEquals(firstExpectedMatrix, Utils.createMatrixWithInfoFromString(firstMatrixInfo));

        String secondMatrixInfo = "3 3\n-2 0 -2\n-3 -3 0\n0 -1 -1";

        List<List<Integer>> secondExpectedMatrix = new ArrayList<>();
        secondExpectedMatrix.add(Arrays.asList(-2, 0, -2));
        secondExpectedMatrix.add(Arrays.asList(-3, -3, 0));
        secondExpectedMatrix.add(Arrays.asList(0, -1, -1));

        assertEquals(secondExpectedMatrix, Utils.createMatrixWithInfoFromString(secondMatrixInfo));
    }
}