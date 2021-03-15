import org.apache.commons.io.FileUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileTaskTest {
    private static final String resourceFileForTestRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileIoExceptionCase =
            "testDataTestRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileIoExceptionCaseFileTask.csv";
    public static final String resourceFileForTestRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileCorrectInputCase =
            "testDataTestRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileCorrectInputCaseFileTask.csv";
    public static final String resourceFileForTestRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileIncorrectSizeInputCase =
            "testDataTestRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileIncorrectSizeInputCase.csv";

    @ParameterizedTest
    @CsvFileSource(resources = resourceFileForTestRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileIoExceptionCase)
    public void testRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileIoExceptionCase(String fileName) {
        assertThrows(IOException.class, ()->new FileTask().rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFile(fileName));
    }

    @ParameterizedTest
    @CsvFileSource(resources = resourceFileForTestRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileCorrectInputCase)
    public void testRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileCorrectInputCase
            (String fileNameWithActualResult, String fileNameWithExpectedResult) throws IOException {

        new FileTask().rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFile(fileNameWithActualResult);

        assertEquals(FileUtils.readLines(new File(fileNameWithExpectedResult), "utf-8"),
                    FileUtils.readLines(new File(fileNameWithActualResult), "utf-8"));

    }

    @ParameterizedTest
    @CsvFileSource(resources = resourceFileForTestRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileIncorrectSizeInputCase)
    public void testRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileIncorrectSizeInputCase(String fileNameWithActualResult){
        assertThrows(NumberFormatException.class,
                ()-> new FileTask().rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFile(fileNameWithActualResult));
    }
}