package BinaryTrees;
/*
https://leetcode.com/problems/trim-a-binary-search-tree/
Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all
its elements lies in [low, high]. You might need to change the root of the tree, so the result should return the new
root of the trimmed binary search tree.
 */

public class TrimBST {
    //*****************Code below is an incorrect attempt**************
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low && root.right != null && root.right.val >= low) {
            TreeNode next = root.right;
            root = next;
        }

        if (root.val < low && root.right == null || root.right.val < low) {
            root = null;
        }

        if (root.val > high) {
            root = null;
        }

        trimBST(root.left, low, high);
        trimBST(root.right, low, high);

        return root;
    }
}
