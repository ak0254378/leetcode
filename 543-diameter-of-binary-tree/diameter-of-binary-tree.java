class Solution {
    private int longestPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath = 0;
        calculateHeight(root);
        return longestPath;
    }
    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        longestPath = Math.max(longestPath, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
