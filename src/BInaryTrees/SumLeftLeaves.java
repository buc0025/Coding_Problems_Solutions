package BInaryTrees;
/*
https://leetcode.com/problems/sum-of-left-leaves/
Find the sum of all left leaves in a given binary tree.
 */

public class SumLeftLeaves {

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
        }

        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);

        return sum;
    }
}
