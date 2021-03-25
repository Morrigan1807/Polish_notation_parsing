package util;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

import static util.Constant.*;

@UtilityClass
public class FileUtil {

    public File rewriteFileWithNewMatrix(String fileName, List<List<Integer>> newMatrix) {
        File fileWithNewMatrix = getFileFromResourcesByActualPath(fileName);

        try (FileWriter writer = new FileWriter(fileWithNewMatrix, false)) {
            writer.write(getPreparedStringWithNewMatrixInfo(newMatrix).toString());

            writer.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return fileWithNewMatrix;
    }

    public static File getFileFromResourcesByResources(String fileName) {
        try {
            return new File((Objects.requireNonNull(FileUtil.class.getClassLoader().getResource(fileName))).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public File getFileFromResourcesByActualPath(String fileName) {
        return new File(PATH_TO_RESOURCES + fileName);
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
        try (FileReader reader = new FileReader(Objects.requireNonNull(getFileFromResourcesByResources(fileName)))) {
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
