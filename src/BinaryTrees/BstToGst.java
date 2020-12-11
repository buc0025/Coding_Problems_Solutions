package BinaryTrees;
/*
https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to
the original key plus sum of all keys greater than the original key in BST.
 */

public class BstToGst {

    // Incorrect solution, the root.val only adds the immediate right child's value
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.val += helper(root.right, root.val, 0);
        bstToGst(root.left);
        bstToGst(root.right);

        return root;
    }

    public int helper(TreeNode root, int val, int sum) {
        if (root == null) {
            return 0;
        }

        if (root.val > val) {
            sum += root.val;
        }

        helper(root.right, val, sum);
        helper(root.left, val, sum);

        return sum;
    }
}
