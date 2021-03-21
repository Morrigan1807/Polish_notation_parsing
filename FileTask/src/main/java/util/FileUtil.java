package util;

import lombok.experimental.UtilityClass;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static util.Constant.*;

@UtilityClass
public class FileUtil {

    public void rewriteFileWithNewMatrix(String fileName, List<List<Integer>> newMatrix) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(getPreparedStringWithNewMatrixInfo(newMatrix).toString());

            writer.flush();
        } catch (IOException ioException) {
            //TODO do smth with this block
            return;
        }
    }

    private StringBuilder getPreparedStringWithNewMatrixInfo(List<List<Integer>> newMatrix) {
        StringBuilder matrixInfoAsString = new StringBuilder();
        matrixInfoAsString.append(getPreparedStringWithSizesNewMatrix(newMatrix));
        for (List<Integer> row : newMatrix) {
            for (Integer element : row) {
                matrixInfoAsString.append(element).append(SPACE);
            }
            matrixInfoAsString.deleteCharAt(matrixInfoAsString.length() - 1);
            matrixInfoAsString.append(LINE_FEED_CHARACTER);
        }
        matrixInfoAsString.deleteCharAt(matrixInfoAsString.length() - 1);
        return matrixInfoAsString;
    }

    private String getPreparedStringWithSizesNewMatrix(List<List<Integer>> newMatrix) {
        return newMatrix.size() + (SPACE) + newMatrix.get(0).size() + LINE_FEED_CHARACTER;
    }

    public String checkAndFixFileNameWithExtension(String fileName) {
        return fileName.endsWith(TXT_EXTENSION) ? fileName : fileName + TXT_EXTENSION;
    }

    public StringBuilder getAllStringsFromFile(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            StringBuilder informationFromTextFile = new StringBuilder();

            int tempChar;

            while ((tempChar = reader.read()) != -1) {
                informationFromTextFile.append((char) tempChar);
            }

            return informationFromTextFile;

        } catch (IOException ignored) {
            return new StringBuilder();
        }
    }
}
