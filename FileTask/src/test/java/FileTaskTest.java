import filetask.FileTask;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.Constant.*;
import static util.FileUtil.getFileFromResourcesByResources;

public class FileTaskTest {

    @ParameterizedTest
    @CsvFileSource(resources = RESOURCE_FILE_FOR_TEST_REARRANGE_LINES_IN_MATRIX_FOR_ZERO_ELEMENTS_ON_THE_MAIN_DIAGONAL_IN_FILE_EXCEPTION_CASE)
    public void testRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileNullPointerExceptionCase(String fileNameToRead) {
        assertThrows(NullPointerException.class,
                () -> new FileTask().getFileWithRearrangedRowsInMatrixForZeroElementsOnMainDiagonal(fileNameToRead, ""));
    }

    @ParameterizedTest
    @CsvFileSource(resources = RESOURCE_FILE_FOR_TEST_REARRANGE_LINES_IN_MATRIX_FOR_ZERO_ELEMENTS_ON_THE_MAIN_DIAGONAL_IN_FILE_CORRECT_INPUT_CASE)
    public void testRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileCorrectInputCase
            (String fileNameForReading, String fileNameWithActualResult, String fileNameWithExpectedResult) throws IOException {
        assertEquals(FileUtils.readLines(Objects.requireNonNull(getFileFromResourcesByResources(
                fileNameWithExpectedResult)), StandardCharsets.UTF_8),
                FileUtils.readLines(new FileTask().getFileWithRearrangedRowsInMatrixForZeroElementsOnMainDiagonal(
                        fileNameForReading, fileNameWithActualResult), StandardCharsets.UTF_8));

    }

    @ParameterizedTest
    @CsvFileSource(resources = RESOURCE_FILE_FOR_TEST_REARRANGE_LINES_IN_MATRIX_FOR_ZERO_ELEMENTS_ON_THE_MAIN_DIAGONAL_IN_FILE_INCORRECT_SIZE_INPUT_CASE)
    public void testRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileIncorrectSizeInputCase(String fileNameWithActualResult) {
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> new FileTask().getFileWithRearrangedRowsInMatrixForZeroElementsOnMainDiagonal(fileNameWithActualResult, ""));
    }
}