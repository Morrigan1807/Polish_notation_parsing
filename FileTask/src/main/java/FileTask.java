import lombok.Data;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class FileTask {
    private int rowSize;
    private int columnsSize;
    private List<List<Integer>> createdMatrixFromString;

    private void rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonal(List<List<Integer>> inputMatrix) {
        int diagonalSize = Math.min(inputMatrix.size(), inputMatrix.get(0).size());
        for (int i = 0; i < diagonalSize - 1; i++) {
            int lineToMoveUp = findLineWithZeroElementInCurrentColumn(inputMatrix, i);

            rearrangeLinesInMatrix(inputMatrix, i, lineToMoveUp);
        }
    }

    private void rearrangeLinesInMatrix(List<List<Integer>> inputMatrix, int toLine, int fromLine) {
        List<Integer> tempLine = inputMatrix.remove(fromLine);
        inputMatrix.add(toLine, tempLine);
    }

    private int findLineWithZeroElementInCurrentColumn(List<List<Integer>> inputMatrix, int currentColumn) {
        for (int i = 0; i < inputMatrix.size(); i++) {
            if (inputMatrix.get(i).get(currentColumn) == 0) {
                return i;
            }
        }

        throw new ArrayStoreException("Cant find zero element for main diagonal.");
    }

    public void rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFile(String fileName) throws IOException {
        StringBuilder str = getAllStringsFromFile(fileName);

        createMatrixWithInfoFromString(str.toString());

        rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonal(createdMatrixFromString);

        rewriteFile(fileName);
    }

    private StringBuilder getAllStringsFromFile(String fileName) throws IOException {
        fileName = checkAndFixFileNameWithExtension(fileName);

        FileReader reader = new FileReader(fileName);
        StringBuilder informationFromTextFile = new StringBuilder();

        int tempChar;

        while((tempChar = reader.read()) != -1){
            informationFromTextFile.append((char) tempChar);
        }

        return informationFromTextFile;
    }

    private String checkAndFixFileNameWithExtension(String fileName) {
        if(!fileName.endsWith(".txt"))
        {
            fileName += ".txt";
        }
        return fileName;
    }

    private void createMatrixWithInfoFromString(String matrixInfo)
    {
        createdMatrixFromString = new ArrayList<>();
        String[] arrayOfLinesInStringMatrixInfo = matrixInfo.split("\n");

        readSizesOfMatrixFromString(arrayOfLinesInStringMatrixInfo[0]);

        readAndCreateMatrixBodyFomStringArray(arrayOfLinesInStringMatrixInfo);
    }

    private void readAndCreateMatrixBodyFomStringArray(String[] arrayOfLinesInStringMatrixInfo) {
        checkTheCorrectSizesOfMatrix(arrayOfLinesInStringMatrixInfo);

        for (int i = 0; i < rowSize; i++)
        {
            String[] arrayOfLinesWithCurrentRowInMatrixAsString = arrayOfLinesInStringMatrixInfo[i+1].split(" ");
            createdMatrixFromString.add(new ArrayList<>());

            parseStringArrayInToIntegerArray(i, arrayOfLinesWithCurrentRowInMatrixAsString);
        }
    }

    private void checkTheCorrectSizesOfMatrix(String[] arrayOfLinesInStringMatrixInfo) {
        if (rowSize != arrayOfLinesInStringMatrixInfo.length - 1)
        {
            throw new ArrayIndexOutOfBoundsException("Matrix sizes do not match.");
        }
    }

    private void parseStringArrayInToIntegerArray(int rowNumber, String[] arrayOfLinesWithCurrentRowInMatrixAsString) {
        for(int j = 0; j < columnsSize; j++)
        {
            createdMatrixFromString.get(rowNumber).add(Integer.parseInt(arrayOfLinesWithCurrentRowInMatrixAsString[j]));
        }
    }

    private void readSizesOfMatrixFromString(String s) {
        String[] arrayOfLinesWithMatrixSizeInfo = s.split(" ");
        rowSize = Integer.parseInt(arrayOfLinesWithMatrixSizeInfo[0]);
        columnsSize = Integer.parseInt(arrayOfLinesWithMatrixSizeInfo[1]);
    }

    private void rewriteFile(String fileName) throws IOException
    {
        FileWriter writer = new FileWriter(fileName, false);

        writer.write(getPreparedStringWithNewMatrixInfo().toString());

        writer.flush();
    }

    private StringBuilder getPreparedStringWithNewMatrixInfo() {
        StringBuilder matrixInfoAsString = new StringBuilder();
        matrixInfoAsString.append(rowSize).append(" ").append(columnsSize).append("\n");
        for(List<Integer> row: createdMatrixFromString)
        {
            for(Integer i: row)
            {
                matrixInfoAsString.append(i).append(" ");
            }
            matrixInfoAsString.deleteCharAt(matrixInfoAsString.length() - 1);
            matrixInfoAsString.append("\n");
        }
        matrixInfoAsString.deleteCharAt(matrixInfoAsString.length() - 1);
        return matrixInfoAsString;
    }
}