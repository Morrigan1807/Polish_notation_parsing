package filetask;

import lombok.Data;
import util.FileUtil;
import util.Utils;

import java.io.File;
import java.util.List;

@Data
public class FileTask {

    public File getFileWithRearrangedRowsInMatrixForZeroElementsOnMainDiagonal(String fileNameToRead, String fileNameToWrite) {
        StringBuilder stringsFromFile = FileUtil.getAllStringsFromFile(FileUtil.checkAndFixFileNameWithExtension(fileNameToRead));

        List<List<Integer>> createdMatrixFromString = Utils.getMatrixWithInformationFromString(stringsFromFile.toString());

        Utils.rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonal(createdMatrixFromString);

        return FileUtil.getFileWithRewrittenNewMatrix(fileNameToWrite, createdMatrixFromString);
    }
}