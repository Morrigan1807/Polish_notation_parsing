import collectionstask.CollectionsTask;
import model.BinaryTree;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CollectionsTaskTest {

    private static Stream<Arguments> getDataForTestGetNumberOfNodesWithTwoBranchesInBinaryTreeAnyResultCase() {
        BinaryTree firstBinaryTree = new BinaryTree();
        firstBinaryTree.setLeftBranch(new BinaryTree());
        firstBinaryTree.setRightBranch(new BinaryTree());
        firstBinaryTree.getRightBranch().setRightBranch(new BinaryTree());
        int firstExpectedResult = 1;

        BinaryTree secondBinaryTree = new BinaryTree();
        secondBinaryTree.setLeftBranch(new BinaryTree());
        secondBinaryTree.setRightBranch(new BinaryTree());
        secondBinaryTree.getLeftBranch().setRightBranch(new BinaryTree());
        secondBinaryTree.getLeftBranch().setLeftBranch(new BinaryTree());
        secondBinaryTree.getRightBranch().setRightBranch(new BinaryTree());
        secondBinaryTree.getRightBranch().setLeftBranch(new BinaryTree());
        int secondExpectedResult = 3;

        BinaryTree thirdBinaryTree = new BinaryTree();
        thirdBinaryTree.setLeftBranch(new BinaryTree());
        thirdBinaryTree.setRightBranch(new BinaryTree());
        thirdBinaryTree.getLeftBranch().setRightBranch(new BinaryTree());
        thirdBinaryTree.getLeftBranch().setLeftBranch(new BinaryTree());
        thirdBinaryTree.getRightBranch().setRightBranch(new BinaryTree());
        thirdBinaryTree.getRightBranch().setLeftBranch(new BinaryTree());
        thirdBinaryTree.getLeftBranch().getLeftBranch().setLeftBranch(new BinaryTree());
        int thirdExpectedResult = 3;

        BinaryTree fourthBinaryTree = new BinaryTree();
        fourthBinaryTree.setLeftBranch(new BinaryTree());
        fourthBinaryTree.setRightBranch(new BinaryTree());
        fourthBinaryTree.getRightBranch().setLeftBranch(new BinaryTree());
        fourthBinaryTree.getRightBranch().setRightBranch(new BinaryTree());
        int fourthExpectedResult = 2;

        return Stream.of(Arguments.arguments(firstBinaryTree, firstExpectedResult),
                Arguments.arguments(secondBinaryTree, secondExpectedResult),
                Arguments.arguments(thirdBinaryTree, thirdExpectedResult),
                Arguments.arguments(fourthBinaryTree, fourthExpectedResult));
    }

    private static Stream<Arguments> getDataForTestGetNumberOfNodesWithTwoBranchesInBinaryTreeZeroResultCase() {
        BinaryTree firstBinaryTree = new BinaryTree();
        firstBinaryTree.setRightBranch(new BinaryTree());
        firstBinaryTree.getRightBranch().setLeftBranch(new BinaryTree());
        int firstExpectedResult = 0;

        BinaryTree secondBinaryTree = new BinaryTree();
        secondBinaryTree.setLeftBranch(new BinaryTree());
        secondBinaryTree.getLeftBranch().setRightBranch(new BinaryTree());
        int secondExpectedResult = 0;

        BinaryTree thirdBinaryTree = new BinaryTree();
        int thirdExpectedResult = 0;

        BinaryTree fourthBinaryTree = new BinaryTree();
        fourthBinaryTree.setRightBranch(new BinaryTree());
        fourthBinaryTree.getRightBranch().setRightBranch(new BinaryTree());
        fourthBinaryTree.getRightBranch().getRightBranch().setRightBranch(new BinaryTree());
        int fourthExpectedResult = 0;

        return Stream.of(Arguments.arguments(firstBinaryTree, firstExpectedResult),
                Arguments.arguments(secondBinaryTree, secondExpectedResult),
                Arguments.arguments(thirdBinaryTree, thirdExpectedResult),
                Arguments.arguments(fourthBinaryTree, fourthExpectedResult));
    }

    @ParameterizedTest
    @MethodSource("getDataForTestGetNumberOfNodesWithTwoBranchesInBinaryTreeAnyResultCase")
    public void testGetNumberOfNodesWithTwoBranchesInBinaryTreeAnyResultCase(BinaryTree binaryTree, Integer expected) {
        assertEquals(expected, new CollectionsTask().getNumberOfNodesWithTwoBranchesInBinaryTree(binaryTree));
    }

    @ParameterizedTest
    @MethodSource("getDataForTestGetNumberOfNodesWithTwoBranchesInBinaryTreeZeroResultCase")
    public void testGetNumberOfNodesWithTwoBranchesInBinaryTreeZeroResultCase(BinaryTree binaryTree, Integer expected) {
        assertEquals(expected, new CollectionsTask().getNumberOfNodesWithTwoBranchesInBinaryTree(binaryTree));
    }

    @Test
    public void testGetNumberOfNodesWithTwoBranchesInBinaryTreeNullParameterCase() {
        CollectionsTask collectionsTask = new CollectionsTask();

        assertThrows(NullPointerException.class, () -> collectionsTask.getNumberOfNodesWithTwoBranchesInBinaryTree(null));
    }
}