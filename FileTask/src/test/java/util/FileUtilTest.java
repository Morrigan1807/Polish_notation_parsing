package util;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.Constant.*;
import static util.FileUtil.getFileFromResourcesByResources;

public class FileUtilTest {

    @Test
    public void testRewriteFileWithNewMatrixThreeByThreeMatrixCase() throws IOException {
        List<List<Integer>> matrixForWriting = Arrays.asList(
                Arrays.asList(3, 3, 3),
                Arrays.asList(-4, -4, -4),
                Arrays.asList(0, 0, 0));

        List<String> expectedStrings = Arrays.asList("3 3", "3 3 3", "-4 -4 -4", "0 0 0");

        assertEquals(expectedStrings, FileUtils.readLines(FileUtil.getFileWithRewrittenNewMatrix(
                DATA_FOR_TEST_REWRITE_FILE_WITH_NEW_MATRIX_FILE_NAME_FOR_REWRITING, matrixForWriting),
                StandardCharsets.UTF_8));
    }

    @Test
    public void testRewriteFileWithNewMatrixThreeByFourMatrixCase() throws IOException {
        List<List<Integer>> matrixForWriting = Arrays.asList(
                Arrays.asList(0, 0, 0, 0),
                Arrays.asList(1, 1, 1, 1),
                Arrays.asList(2, 2, 2, 2));

        List<String> expectedStrings = Arrays.asList("3 4", "0 0 0 0", "1 1 1 1", "2 2 2 2");

        assertEquals(expectedStrings, FileUtils.readLines(FileUtil.getFileWithRewrittenNewMatrix(
                DATA_FOR_TEST_REWRITE_FILE_WITH_NEW_MATRIX_FILE_NAME_FOR_REWRITING, matrixForWriting),
                StandardCharsets.UTF_8));
    }

    @Test
    public void testCheckAndFixFileNameWithExtensionWithExtensionCase() {
        assertEquals(DATA_FOR_TEST_CHECK_AND_FIX_FILE_NAME_WITH_EXTENSION_FILE_NAME_WITH_EXTENSION,
                FileUtil.checkAndFixFileNameWithExtension(DATA_FOR_TEST_CHECK_AND_FIX_FILE_NAME_WITH_EXTENSION_FILE_NAME_WITH_EXTENSION));
    }

    @Test
    public void testCheckAndFixFileNameWithExtensionWithoutExtensionCase() {
        assertEquals(DATA_FOR_TEST_CHECK_AND_FIX_FILE_NAME_WITH_EXTENSION_FILE_NAME_WITH_EXTENSION,
                FileUtil.checkAndFixFileNameWithExtension(DATA_FOR_TEST_CHECK_AND_FIX_FILE_NAME_WITH_EXTENSION_FILE_NAME_WITHOUT_EXTENSION));
    }

    @Test
    public void testGetAllStringsFromFile() throws IOException {
        List<String> expectedStrings = Arrays.asList("3 3", "0 8 7", "9 0 1", "2 1 0");

        assertEquals(expectedStrings, FileUtils.readLines(
                Objects.requireNonNull(getFileFromResourcesByResources(DATA_FOR_TEST_GET_ALL_STRINGS_FROM_FILE_FILE_NAME_WITH_STRINGS_FOR_READING)),
                StandardCharsets.UTF_8));
    }
}