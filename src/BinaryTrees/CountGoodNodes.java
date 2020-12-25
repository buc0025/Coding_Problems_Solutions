package BinaryTrees;
/*
https://leetcode.com/problems/count-good-nodes-in-binary-tree/
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater
than X.

Return the number of good nodes in the binary tree.
 */

public class CountGoodNodes {

    // Incorrect solution. Misunderstanding of problem and couldn't figure out how to keep track of max value in path
    int sum = 1;
    public int goodNodes(TreeNode root) {
        int num = root.val;

        return helper(root, num);
    }

    public int helper(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }

        if (root.left != null && root.left.val >= root.val && root.left.val >= num) {
            sum++;
        }

        if (root.right != null && root.right.val >= root.val && root.right.val >= num) {
            sum++;
        }

        helper(root.left, num);
        helper(root.right, num);

        return sum;
    }
}
