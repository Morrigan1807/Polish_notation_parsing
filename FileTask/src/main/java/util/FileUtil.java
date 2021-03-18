package util;

import lombok.experimental.UtilityClass;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@UtilityClass
public class FileUtil {

    public void rewriteFileWithNewMatrix(String fileName, List<List<Integer>> newMatrix) throws IOException {
        FileWriter writer = new FileWriter(fileName, false);

        writer.write(getPreparedStringWithNewMatrixInfo(newMatrix).toString());

        writer.flush();
    }

    private StringBuilder getPreparedStringWithNewMatrixInfo(List<List<Integer>> newMatrix) {
        StringBuilder matrixInfoAsString = new StringBuilder();
        matrixInfoAsString.append(getPreparedStringWithSizesNewMatrix(newMatrix));
        for (List<Integer> row : newMatrix) {
            for (Integer element : row) {
                matrixInfoAsString.append(element).append(" ");
            }
            matrixInfoAsString.deleteCharAt(matrixInfoAsString.length() - 1);
            matrixInfoAsString.append("\n");
        }
        matrixInfoAsString.deleteCharAt(matrixInfoAsString.length() - 1);
        return matrixInfoAsString;
    }

    private String getPreparedStringWithSizesNewMatrix(List<List<Integer>> newMatrix) {
        return newMatrix.size() + (" ") + newMatrix.get(0).size() + "\n";
    }

    public String checkAndFixFileNameWithExtension(String fileName) {
        return fileName.endsWith(".txt") ? fileName : fileName + ".txt";
    }

    public StringBuilder getAllStringsFromFile(String fileName) throws IOException {
        FileReader reader = new FileReader(fileName);
        StringBuilder informationFromTextFile = new StringBuilder();

        int tempChar;

        while ((tempChar = reader.read()) != -1) {
            informationFromTextFile.append((char) tempChar);
        }

        return informationFromTextFile;
    }
}
