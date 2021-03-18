import lombok.Data;
import util.FileUtil;
import util.Utils;

import java.io.IOException;
import java.util.List;

@Data
public class FileTask {
    private List<List<Integer>> createdMatrixFromString;

    public void rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonalInFile(String fileName) throws IOException {
        StringBuilder stringsFromFile = FileUtil.getAllStringsFromFile(FileUtil.checkAndFixFileNameWithExtension(fileName));

        createdMatrixFromString = Utils.createMatrixWithInfoFromString(stringsFromFile.toString());

        Utils.rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonal(createdMatrixFromString);

        FileUtil.rewriteFileWithNewMatrix(fileName, createdMatrixFromString);
    }
}