package BInaryTrees;
/*
https://leetcode.com/problems/invert-binary-tree/
Invert a binary tree.
 */

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode t1 = new TreeNode(root.val);
        t1.left = invertTree(root.right);
        t1.right = invertTree(root.left);

        return t1;
    }
}
