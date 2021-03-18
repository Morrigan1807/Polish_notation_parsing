public class CollectionsTask {

    public int getNumberOfNodesWithTwoBranchesInBinaryTree(BinaryTree binaryTree) {
        checkNullParameter(binaryTree);

        if (binaryTree.getLeftBranch() != null && binaryTree.getRightBranch() != null) {
            return getNumberOfNodesWithTwoBranchesInLeftBranch(binaryTree) +
                    getNumberOfNodesWithTwoBranchesInRightBranch(binaryTree) + 1;
        } else if (binaryTree.getLeftBranch() != null) {
            return getNumberOfNodesWithTwoBranchesInLeftBranch(binaryTree);
        } else if (binaryTree.getRightBranch() != null) {
            return getNumberOfNodesWithTwoBranchesInRightBranch(binaryTree);
        }

        return 0;
    }

    private int getNumberOfNodesWithTwoBranchesInRightBranch(BinaryTree binaryTree) {
        return getNumberOfNodesWithTwoBranchesInBinaryTree(binaryTree.getRightBranch());
    }

    private int getNumberOfNodesWithTwoBranchesInLeftBranch(BinaryTree binaryTree) {
        return getNumberOfNodesWithTwoBranchesInBinaryTree(binaryTree.getLeftBranch());
    }

    private void checkNullParameter(BinaryTree binaryTree) {
        if (binaryTree == null) {
            throw new NullPointerException("Null input.");
        }
    }
}
