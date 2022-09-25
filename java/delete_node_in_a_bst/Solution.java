package delete_node_in_a_bst;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            root.val = min(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    public int min(TreeNode root) {
        if (root.left == null)
            return root.val;
        else
            return min(root.left);
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
