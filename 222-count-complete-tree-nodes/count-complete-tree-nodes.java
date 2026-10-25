class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int height = getHeight(root);

        if (height == 0) {
            return 1;
        }

        int left = 0;
        int right = (1 << height) - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (exists(mid, height, root)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return ((1 << height) - 1) + left + 1;
    }

    private int getHeight(TreeNode node) {
        int height = 0;

        while (node.left != null) {
            height++;
            node = node.left;
        }

        return height;
    }

    private boolean exists(int index, int height, TreeNode node) {
        int left = 0;
        int right = (1 << height) - 1;

        for (int i = 0; i < height; i++) {
            int mid = left + (right - left) / 2;

            if (index <= mid) {
                node = node.left;
                right = mid;
            } else {
                node = node.right;
                left = mid + 1;
            }
        }

        return node != null;
    }
}
