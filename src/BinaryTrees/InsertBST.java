package BinaryTrees;
/*
https://leetcode.com/problems/insert-into-a-binary-search-tree/
Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the
BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the
original BST.

Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
You can return any of them.
 */

public class InsertBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);

        if (root == null) {
            return node;
        }
        // Insert node into  tree when current val is no longer greater than given val
        if (root.val < val) {
            if (root.right != null) {
                insertIntoBST(root.right, val);
            }else {
                // Current node's right subtree will become new node's right subtree
                TreeNode replace = root.right;
                root.right = node;
                node.right = replace;
            }
        }
        // Insert node into  tree when current val is no longer less than given val
        if (root.val > val) {
            if (root.left != null) {
                insertIntoBST(root.left, val);
            }else {
                // Current node's left subtree will become new node's left subtree
                TreeNode replace = root.left;
                root.left = node;
                node.left = replace;
            }
        }
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            if (root.left != null) {
                insertIntoBST(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }
        } else {
            if (root.right != null) {
                insertIntoBST(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        }
        return root;
    }
}
