public class CollectionsTask {

    public int getNumberOfNodesWithTwoBranchesInBinaryTree(BinaryTree binaryTree)
    {
        checkNullParameter(binaryTree);

        if (binaryTree.getLeftBranch() != null && binaryTree.getRightBranch() != null)
        {
            return getNumberOfNodesWithTwoBranchesInBinaryTree(binaryTree.getLeftBranch()) +
                    getNumberOfNodesWithTwoBranchesInBinaryTree(binaryTree.getRightBranch()) + 1;
        }
        else if(binaryTree.getLeftBranch() != null)
        {
            return getNumberOfNodesWithTwoBranchesInBinaryTree(binaryTree.getLeftBranch());
        }
        else if (binaryTree.getRightBranch() != null)
        {
            return getNumberOfNodesWithTwoBranchesInBinaryTree(binaryTree.getRightBranch());
        }

        return 0;
    }

    private void checkNullParameter(BinaryTree binaryTree) {
        if (binaryTree == null)
        {
            throw new NullPointerException("Null input.");
        }
    }
}
