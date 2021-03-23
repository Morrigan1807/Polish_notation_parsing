import filetask.FileTask;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.Constant.*;

class FileTaskTest {
    @ParameterizedTest
    @CsvFileSource(resources = RESOURCE_FILE_FOR_TEST_REARRANGE_LINES_IN_MATRIX_FOR_ZERO_ELEMENTS_ON_THE_MAIN_DIAGONAL_IN_FILE_IOEXCEPTION_CASE)
    void testRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileNumberFormatExceptionCase(String fileName) {
        FileTask fileTask = new FileTask();

        assertThrows(NumberFormatException.class, () -> fileTask.rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFile(fileName));
    }

    @ParameterizedTest
    @CsvFileSource(resources = RESOURCE_FILE_FOR_TEST_REARRANGE_LINES_IN_MATRIX_FOR_ZERO_ELEMENTS_ON_THE_MAIN_DIAGONAL_IN_FILE_CORRECT_INPUT_CASE)
    void testRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileCorrectInputCase
            (String fileNameWithActualResult, String fileNameWithExpectedResult) throws IOException {

        new FileTask().rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFile(fileNameWithActualResult);

        assertEquals(FileUtils.readLines(new File(fileNameWithExpectedResult), StandardCharsets.UTF_8),
                FileUtils.readLines(new File(fileNameWithActualResult), StandardCharsets.UTF_8));

    }

    @ParameterizedTest
    @CsvFileSource(resources = RESOURCE_FILE_FOR_TEST_REARRANGE_LINES_IN_MATRIX_FOR_ZERO_ELEMENTS_ON_THE_MAIN_DIAGONAL_IN_FILE_INCORRECT_SIZE_INPUT_CASE)
    void testRearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFileIncorrectSizeInputCase(String fileNameWithActualResult) {
        FileTask fileTask = new FileTask();

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> fileTask.rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFile(fileNameWithActualResult));
    }
}