package binary_tree_tilt;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class Solution {
    int ans;

    public int findTilt(TreeNode root) {
        postOrder(root);
        return ans;
    }

    int postOrder(TreeNode root) {
        if (root == null) return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        ans += Math.abs(left - right);
        return root.val + left + right;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}