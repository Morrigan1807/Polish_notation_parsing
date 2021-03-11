import java.util.ArrayList;
import java.util.List;

public class FileTask {
    //В файле, имя которого задается с клавиатуры, записаны размеры матрицы и сама матрица.
    //Известно, что в каждой строке и в каждом столбце есть единственный нулевой элемент.
    //Переставить строки так, чтобы эти элементы оказались на главной диагонали.
    //Покрыть решение тестами. Для каждого метода минимум 3 теста.

    private static void rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonal(List<List<Integer>> inputMatrix) {
        int diagonalSize = Math.min(inputMatrix.size(), inputMatrix.get(0).size());
        for (int i = 0; i < diagonalSize - 1; i++) {
            int lineToMoveUp = findLineWithZeroElementInCurrentColumn(inputMatrix, i);

            rearrangeLinesInMatrix(inputMatrix, i, lineToMoveUp);
        }
    }

    private static void rearrangeLinesInMatrix(List<List<Integer>> inputMatrix, int toLine, int fromLine) {
        List<Integer> tempLine = inputMatrix.remove(fromLine);
        inputMatrix.add(toLine, tempLine);
    }

    private static int findLineWithZeroElementInCurrentColumn(List<List<Integer>> inputMatrix, int currentColumn) {
        for (int i = 0; i < inputMatrix.size(); i++) {
            if (inputMatrix.get(i).get(currentColumn) == 0) {
                return i;
            }
        }

        throw new ArrayStoreException("Cant find zero element for main diagonal.");
    }


    public static void main(String[] args) {
        List<List<Integer>> inputMatrix = new ArrayList<>();
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(1);
        temp1.add(0);
        temp1.add(1);
        inputMatrix.add(temp1);
        List<Integer> temp2 = new ArrayList<>();
        temp2.add(2);
        temp2.add(2);
        temp2.add(0);
        inputMatrix.add(temp2);
        List<Integer> temp3 = new ArrayList<>();
        temp3.add(0);
        temp3.add(3);
        temp3.add(3);
        inputMatrix.add(temp3);

        rearrangeLinesInMatrixForZeroElementsOnTheMainDiagonal(inputMatrix);

        for (List<Integer> list : inputMatrix) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}