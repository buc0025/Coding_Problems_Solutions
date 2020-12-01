package BinaryTrees;
/*
https://leetcode.com/problems/subtree-of-another-tree/
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a
subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could
also be considered as a subtree of itself.
 */

public class SameSubtree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        if (sameTree(s, t)) {
            return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean sameTree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == t;
        }

        if (s.val == t.val) {
            return sameTree(s.left, t.left) && sameTree(s.right, t.right);
        }

        return sameTree(s.left, t) && sameTree(s.right, t);
    }

//*********Incorrect Solution, couldn't figure out how to check remaining subtree of s if t is part of s subtree*******
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == t;
        }
        return helper(s.left, t) || helper(s.right, t);
    }

    public boolean helper(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == t;
        }
        if (s.val != t.val) {
            return false;
        }
        return helper(s.left, t.left) || helper(s.right, t.right);
    }


    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == t;
        }

        if (isSameTree(s, t)) {
            return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right,t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == t;
        }

        if (s.val != t.val) {
            return false;
        }

        return  isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
