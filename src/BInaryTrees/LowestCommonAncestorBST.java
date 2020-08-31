package BInaryTrees;
/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */

public class LowestCommonAncestorBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }
}
