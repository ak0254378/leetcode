class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        nodes.push(root);
        sums.push(root.val);
        while (!nodes.isEmpty()) {
            TreeNode current = nodes.pop();
            int sum = sums.pop();
            if (current.left == null && current.right == null
                    && sum == targetSum) {
                return true;
            }
            if (current.right != null) {
                nodes.push(current.right);
                sums.push(sum + current.right.val);
            }
            if (current.left != null) {
                nodes.push(current.left);
                sums.push(sum + current.left.val);
            }
        }
        return false;
    }
}
