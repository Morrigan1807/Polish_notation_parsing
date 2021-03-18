package util;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {

    @Test
    void testRewriteFileWithNewMatrix() throws IOException{
        String fileNameWithStringsForRewriting = "src\\test\\resources\\files_for_tests\\fileForRewriting.txt";

        List<List<Integer>> firstMatrixForWriting = new ArrayList<>();
        firstMatrixForWriting.add(Arrays.asList(3, 3, 3));
        firstMatrixForWriting.add(Arrays.asList(-4, -4, -4));
        firstMatrixForWriting.add(Arrays.asList(0, 0, 0));

        List<String> firstExpectedStrings = Arrays.asList("3 3", "3 3 3", "-4 -4 -4", "0 0 0");

        FileUtil.rewriteFileWithNewMatrix(fileNameWithStringsForRewriting, firstMatrixForWriting);

        assertEquals(firstExpectedStrings, FileUtils.readLines(new File(fileNameWithStringsForRewriting), "utf-8"));

        List<List<Integer>> secondMatrixForWriting = new ArrayList<>();
        secondMatrixForWriting.add(Arrays.asList(0, 0, 0, 0));
        secondMatrixForWriting.add(Arrays.asList(1, 1, 1, 1));
        secondMatrixForWriting.add(Arrays.asList(2, 2, 2, 2));

        List<String> secondExpectedStrings = Arrays.asList("3 4", "0 0 0 0", "1 1 1 1", "2 2 2 2");

        FileUtil.rewriteFileWithNewMatrix(fileNameWithStringsForRewriting, secondMatrixForWriting);

        assertEquals(secondExpectedStrings, FileUtils.readLines(new File(fileNameWithStringsForRewriting), "utf-8"));
    }

    @Test
    void testCheckAndFixFileNameWithExtension() {
        String fileNameWithExtensionFoeInput = "hello.txt";
        String expectedResultForFileNameWithExtensionFoeInput = "hello.txt";

        assertEquals(expectedResultForFileNameWithExtensionFoeInput,
                FileUtil.checkAndFixFileNameWithExtension(fileNameWithExtensionFoeInput));

        String fileNameWithoutExtensionFoeInput = "hello";
        String expectedResultForFileNameWithoutExtensionFoeInput = "hello.txt";

        assertEquals(expectedResultForFileNameWithoutExtensionFoeInput,
                FileUtil.checkAndFixFileNameWithExtension(fileNameWithoutExtensionFoeInput));
    }

    @Test
    void testGetAllStringsFromFile() throws IOException {
        String fileNameWithStringsForReading = "src\\test\\resources\\files_for_tests\\fileExp.txt";
        List<String> expectedStrings = Arrays.asList("3 3", "0 8 7", "9 0 1", "2 1 0");

        assertEquals(expectedStrings, FileUtils.readLines(new File(fileNameWithStringsForReading), "utf-8"));
    }
}