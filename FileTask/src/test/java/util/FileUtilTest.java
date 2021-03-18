package util;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.Constant.*;

class FileUtilTest {

    @Test
    void testRewriteFileWithNewMatrix() throws IOException {
        List<List<Integer>> firstMatrixForWriting = new ArrayList<>();
        firstMatrixForWriting.add(Arrays.asList(3, 3, 3));
        firstMatrixForWriting.add(Arrays.asList(-4, -4, -4));
        firstMatrixForWriting.add(Arrays.asList(0, 0, 0));

        List<String> firstExpectedStrings = Arrays.asList("3 3", "3 3 3", "-4 -4 -4", "0 0 0");

        FileUtil.rewriteFileWithNewMatrix(DATA_FOR_TEST_REWRITE_FILE_WITH_NEW_MATRIX_FILE_NAME_WITH_STRINGS_FOR_REWRITING,
                firstMatrixForWriting);

        assertEquals(firstExpectedStrings, FileUtils.readLines(
                new File(DATA_FOR_TEST_REWRITE_FILE_WITH_NEW_MATRIX_FILE_NAME_WITH_STRINGS_FOR_REWRITING),
                StandardCharsets.UTF_8));

        List<List<Integer>> secondMatrixForWriting = new ArrayList<>();
        secondMatrixForWriting.add(Arrays.asList(0, 0, 0, 0));
        secondMatrixForWriting.add(Arrays.asList(1, 1, 1, 1));
        secondMatrixForWriting.add(Arrays.asList(2, 2, 2, 2));

        List<String> secondExpectedStrings = Arrays.asList("3 4", "0 0 0 0", "1 1 1 1", "2 2 2 2");

        FileUtil.rewriteFileWithNewMatrix(DATA_FOR_TEST_REWRITE_FILE_WITH_NEW_MATRIX_FILE_NAME_WITH_STRINGS_FOR_REWRITING,
                secondMatrixForWriting);

        assertEquals(secondExpectedStrings, FileUtils.readLines(
                new File(DATA_FOR_TEST_REWRITE_FILE_WITH_NEW_MATRIX_FILE_NAME_WITH_STRINGS_FOR_REWRITING),
                StandardCharsets.UTF_8));
    }

    @Test
    void testCheckAndFixFileNameWithExtension() {
        assertEquals(DATA_FOR_TEST_CHECK_AND_FIX_FILE_NAME_WITH_EXTENSION_FILE_NAME_WITH_EXTENSION,
                FileUtil.checkAndFixFileNameWithExtension(DATA_FOR_TEST_CHECK_AND_FIX_FILE_NAME_WITH_EXTENSION_FILE_NAME_WITH_EXTENSION));

        assertEquals(DATA_FOR_TEST_CHECK_AND_FIX_FILE_NAME_WITH_EXTENSION_FILE_NAME_WITH_EXTENSION,
                FileUtil.checkAndFixFileNameWithExtension(DATA_FOR_TEST_CHECK_AND_FIX_FILE_NAME_WITH_EXTENSION_FILE_NAME_WITHOUT_EXTENSION));
    }

    @Test
    void testGetAllStringsFromFile() throws IOException {
        List<String> expectedStrings = Arrays.asList("3 3", "0 8 7", "9 0 1", "2 1 0");

        assertEquals(expectedStrings, FileUtils.readLines(
                new File(DATA_FOR_TEST_GET_ALL_STRINGS_FROM_FILE_FILE_NAME_WITH_STRINGS_FOR_READING),
                StandardCharsets.UTF_8));
    }
}