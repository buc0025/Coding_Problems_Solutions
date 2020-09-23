package BinaryTrees;
/*
https://leetcode.com/problems/leaf-similar-trees/
Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
Two binary trees are considered leaf-similar if their leaf value sequence is the same.
Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */

public class LeafSimilarTrees {
    String leftTree = "";
    String rightTree = "";
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return leftRoot(root1).equals(rightRoot(root2));
    }
    // method used to determine string value of left tree's leaves
    public String leftRoot(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            leftTree += String.valueOf(root.val) + " ";
        }

        leftRoot(root.left);
        leftRoot(root.right);

        return leftTree;
    }
    // method used to determine string value of right tree's leaves
    public String rightRoot(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            rightTree += String.valueOf(root.val) + " ";
        }

        rightRoot(root.left);
        rightRoot(root.right);

        return rightTree;
    }
}
