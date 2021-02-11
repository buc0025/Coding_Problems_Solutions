package BinaryTrees;
/*
https://leetcode.com/problems/merge-two-binary-trees/
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are
overlapped while the others are not. You need to merge them into a new binary tree. The merge rule is that if two nodes
overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the
node of new tree.
 */

public class MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

    // Incorrect solution. Should've returned the tree2 if tree1 was null and vice versa
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        if (t1 == null && t2 != null) {
            t1 = t2;

        }

        if (t1 != null && t2 == null) {
            return t1;
        }

        if (t1 != null && t2 != null) {
            t1.val += t2.val;
        }

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }

    // Incorrect solution. Idea was to assign t2 to t1 if t1 was null but then I noticed I did it again in the
    // the second if statement after checking the solution. The recursive call at the bottom also runs into a null
    // pointer exception.
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }

        if (t1 == null && t2 != null) {
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
        }

        if (t1 != null && t2 != null) {
            t1.val += t2.val;
        }

        mergeTrees(t1.left, t2.left);
        mergeTrees(t1.right, t2.right);

        return t1;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;

    }
}
