package BinaryTrees;
/*
https://leetcode.com/problems/trim-a-binary-search-tree/
Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all
its elements lies in [low, high]. You might need to change the root of the tree, so the result should return the new
root of the trimmed binary search tree.
 */

public class TrimBST {

    // Incorrect attempt. Super frustrating because this I got this problem wrong just a week ago
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            // Assigning right subtree to current node
            if (root.right != null && root.right.val >= low) {
                root = root.right;
            } else {
                // node is null because it's either a leaf or right child is less than low
                root = null;
            }
        }

        if (root.val > high) {
            // Assigning left subtree to current node
            if (root.left != null && root.left.val <= low) {
                root = root.left;
            } else {
                // node is null because it's either a leaf or left child is greater than high
                root = null;
            }
        }

        trimBST(root.left, low, high);
        trimBST(root.right, low, high);

        return root;
    }

    //*****************Code below is an incorrect attempt**************
    // Idea was to check if a node was lower than low or higher than high and then check if they have an children.
    // If a node value was lower than low and had a right child that was greater than low, then that will become the new
    // node. The same goes for left child of a node value that's higher than high but to check if it's lower than high
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            if (root.right != null && root.right.val >= low) {
                root = root.right;
            }
            else if (root.left == null && root.right == null) {
                root = null;
            }
        }

        if (root.val > high) {
            if (root.left == null && root.right == null) {
                root = null;
            }
            if (root.left != null && root.left.val <= high) {
                root = root.left;
            }
        }

        trimBST(root.left, low, high);
        trimBST(root.right, low, high);

        return root;
    }

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
