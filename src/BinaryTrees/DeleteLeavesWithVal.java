package BinaryTrees;
/*
https://leetcode.com/problems/delete-leaves-with-a-given-value/
Given a binary tree root and an integer target, delete all the leaf nodes with value target.

Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the value target, it
should also be deleted (you need to continue doing that until you can't).
 */

public class DeleteLeavesWithVal {

    //Incorrect solution, only deletes the leaf if it's the given value once.
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        return root;
    }
}
