package BInaryTrees;
/*
https://leetcode.com/problems/subtree-of-another-tree/
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a
subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could
also be considered as a subtree of itself.
 */

public class SameSubtree {

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
