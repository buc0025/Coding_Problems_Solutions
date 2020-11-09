package BinaryTrees;
/*
https://leetcode.com/problems/invert-binary-tree/
Invert a binary tree.
 */

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Swapping nodes
        TreeNode left = root.right;
        TreeNode right = root.left;

        //Reassigning swapped nodes
        root.right = right;
        root.left = left;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode t1 = new TreeNode(root.val);
        t1.left = invertTree(root.right);
        t1.right = invertTree(root.left);

        return t1;
    }
}
