package BInaryTrees;
/*
https://leetcode.com/problems/univalued-binary-tree/
A binary tree is univalued if every node in the tree has the same value.
Return true if and only if the given tree is univalued.
 */

public class UnivaluedBST {

    public boolean isUnivalTree(TreeNode root) {
        return sameNum(root, root.val);
    }

    public boolean sameNum(TreeNode root, int num) {
        if (root == null) {
            return true;
        }
        if (root.val != num) {
            return false;
        }
        return sameNum(root.left, num) && sameNum(root.right, num);
    }
}
