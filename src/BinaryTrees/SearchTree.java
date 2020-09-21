package BinaryTrees;
/*
https://leetcode.com/problems/search-in-a-binary-search-tree/
Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's
value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 */

public class SearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        }

        return  searchBST(root.right, val) ;

    }
}
