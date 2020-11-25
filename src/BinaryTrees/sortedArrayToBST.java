package BinaryTrees;
/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node
never differ by more than 1.
 */

public class sortedArrayToBST {

    // Incorrect attempt. I thought I could try to assign elements from middle of the array to the beginning of the array to
    // left subtree and all the elements after the middle of the array to the right subtree
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length / 2;
        int end = nums.length - 1;

        TreeNode root = new TreeNode(nums[mid]);
        mid--;

        while (mid >= 0) {
            root.left = new TreeNode(nums[mid]);
            mid--;
        }

        while (end < nums.length / 2) {
            root.right = new TreeNode(nums[end]);
            end--;
        }

        return root;
    }
}
