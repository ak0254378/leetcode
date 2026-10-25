import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[]{root1, root2});

        while (!queue.isEmpty()) {
            TreeNode[] pair = queue.poll();
            TreeNode first = pair[0];
            TreeNode second = pair[1];

            first.val += second.val;

            if (first.left == null) {
                first.left = second.left;
            } else if (second.left != null) {
                queue.offer(new TreeNode[]{first.left, second.left});
            }

            if (first.right == null) {
                first.right = second.right;
            } else if (second.right != null) {
                queue.offer(new TreeNode[]{first.right, second.right});
            }
        }

        return root1;
    }
}
