import filetask.FileTask;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import util.FileUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.Constant.*;
import static util.FileUtil.getFileFromResourcesByResources;

class FileTaskTest {

    @ParameterizedTest
    @CsvFileSource(resources = RESOURCE_FILE_FOR_TEST_REARRANGE_LINES_IN_MATRIX_FOR_ZERO_ELEMENTS_ON_THE_MAIN_DIAGONAL_IN_FILE_IOEXCEPTION_CASE)
    void testRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileNullPointerExceptionCase(String fileNameToRead) {
        FileTask fileTask = new FileTask();

        assertThrows(NullPointerException.class,
                () -> fileTask.rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFile(fileNameToRead, ""));
    }

    @ParameterizedTest
    @CsvFileSource(resources = RESOURCE_FILE_FOR_TEST_REARRANGE_LINES_IN_MATRIX_FOR_ZERO_ELEMENTS_ON_THE_MAIN_DIAGONAL_IN_FILE_CORRECT_INPUT_CASE)
    void testRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileCorrectInputCase
            (String fileNameForReading, String fileNameWithActualResult, String fileNameWithExpectedResult) throws IOException {

        FileTask fileTask = new FileTask();

        assertEquals(FileUtils.readLines(Objects.requireNonNull(getFileFromResourcesByResources(fileNameWithExpectedResult)), StandardCharsets.UTF_8),
                FileUtils.readLines(fileTask.rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFile(fileNameForReading, fileNameWithActualResult), StandardCharsets.UTF_8));

    }

    @ParameterizedTest
    @CsvFileSource(resources = RESOURCE_FILE_FOR_TEST_REARRANGE_LINES_IN_MATRIX_FOR_ZERO_ELEMENTS_ON_THE_MAIN_DIAGONAL_IN_FILE_INCORRECT_SIZE_INPUT_CASE)
    void testRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileIncorrectSizeInputCase(String fileNameWithActualResult) {
        FileTask fileTask = new FileTask();

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> fileTask.rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFile(fileNameWithActualResult, ""));
    }
}