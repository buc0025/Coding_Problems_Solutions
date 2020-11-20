package BinaryTrees;
/*
https://leetcode.com/problems/range-sum-of-bst/
Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.
 */

public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        return sum;
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        if (root.val >= L && root.val <= R) {
            return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R) + root.val;
        }

        return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}
