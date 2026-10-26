class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int total = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                total += root.left.val;
            } else {
                total += sumOfLeftLeaves(root.left);
            }
        }
        total += sumOfLeftLeaves(root.right);
        return total;
    }
}
