package util;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

import static util.Constant.*;


@UtilityClass
public class Utils {

    public void rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonal(List<List<Integer>> inputMatrix) {
        for (int i = 0; i < getDiagonalSize(inputMatrix) - 1; i++) {
            int lineToMoveUp = findLineWithZeroElementInCurrentColumn(inputMatrix, i);

            rearrangeLinesInMatrix(inputMatrix, lineToMoveUp, i);
        }
    }

    public List<List<Integer>> createMatrixWithInfoFromString(String matrixInfo) {
        String[] arrayOfLinesInStringMatrixInfo = matrixInfo.split(REGEX_CARRIAGE_RETURN_CHARACTER_AND_LINE_FEED_CHARACTER_OR_LINE_FEED_CHARACTER_ONLY);

        int[] sizes = readSizesOfMatrixFromString(arrayOfLinesInStringMatrixInfo[0]);

        return readAndCreateMatrixBodyFomStringArray(arrayOfLinesInStringMatrixInfo, sizes[0], sizes[1]);
    }

    private int getDiagonalSize(List<List<Integer>> inputMatrix) {
        return Math.min(inputMatrix.size(), inputMatrix.get(0).size());
    }

    private void rearrangeLinesInMatrix(List<List<Integer>> inputMatrix, int fromLine, int toLine) {
        List<Integer> tempLine = inputMatrix.remove(fromLine);
        inputMatrix.add(toLine, tempLine);
    }

    private int findLineWithZeroElementInCurrentColumn(List<List<Integer>> inputMatrix, int currentColumn) {
        for (int i = 0; i < inputMatrix.size(); i++) {
            if (inputMatrix.get(i).get(currentColumn) == 0) {
                return i;
            }
        }
        throw new ArrayStoreException(MESSAGE_FOR_ARRAY_STORE_EXCEPTION);
    }

    private List<List<Integer>> readAndCreateMatrixBodyFomStringArray(String[] arrayOfLinesInStringMatrixInfo,
                                                                      int rowSize, int columnSize) {
        checkTheCorrectSizesOfMatrix(arrayOfLinesInStringMatrixInfo, rowSize);

        List<List<Integer>> createdMatrixFromString = new ArrayList<>();
        for (int i = 0; i < rowSize; i++) {
            String[] arrayOfLinesWithCurrentRowInMatrixAsString = arrayOfLinesInStringMatrixInfo[i + 1].split(Constant.SPACE);
            createdMatrixFromString.add(new ArrayList<>());

            parseStringArrayInToIntegerArray(arrayOfLinesWithCurrentRowInMatrixAsString, i, columnSize, createdMatrixFromString);
        }

        return createdMatrixFromString;
    }

    private void checkTheCorrectSizesOfMatrix(String[] arrayOfLinesInStringMatrixInfo, int rowSize) {
        if (rowSize != arrayOfLinesInStringMatrixInfo.length - 1) {
            throw new ArrayIndexOutOfBoundsException(MESSAGE_FOR_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION);
        }
    }

    private void parseStringArrayInToIntegerArray(String[] arrayOfLinesWithCurrentRowInMatrixAsString, int rowNumber,
                                                  int columnsSize, List<List<Integer>> createdMatrixFromString) {
        for (int j = 0; j < columnsSize; j++) {
            createdMatrixFromString.get(rowNumber).add(Integer.parseInt(arrayOfLinesWithCurrentRowInMatrixAsString[j]));
        }
    }

    private int[] readSizesOfMatrixFromString(String stringWithSizes) {
        String[] arrayOfLinesWithMatrixSizeInfo = stringWithSizes.split(Constant.SPACE);

        return new int[]{Integer.parseInt(arrayOfLinesWithMatrixSizeInfo[0]), Integer.parseInt(arrayOfLinesWithMatrixSizeInfo[1])};
    }
}
