class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode previous = null;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode node = stack.peek();

                if (node.right != null && previous != node.right) {
                    current = node.right;
                } else {
                    result.add(node.val);
                    previous = stack.pop();
                }
            }
        }
        return result;
    }
}
