package filetask;

import lombok.Data;
import util.FileUtil;
import util.Utils;

import java.io.File;
import java.util.List;

@Data
public class FileTask {

    private List<List<Integer>> createdMatrixFromString;

    public File rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFile(String fileNameToRead, String fileNameToWrite) {
        StringBuilder stringsFromFile = FileUtil.getAllStringsFromFile(FileUtil.checkAndFixFileNameWithExtension(fileNameToRead));

        createdMatrixFromString = Utils.createMatrixWithInfoFromString(stringsFromFile.toString());

        Utils.rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonal(createdMatrixFromString);

        return FileUtil.rewriteFileWithNewMatrix(fileNameToWrite, createdMatrixFromString);
    }
}