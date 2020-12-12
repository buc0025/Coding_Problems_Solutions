package BinaryTrees;
/*
https://leetcode.com/problems/maximum-binary-tree/
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.
 */

public class MaxBinaryTree {

    /* Incorrect solution. Passes initial test case. Still not understanding the problem statement. My understanding was that the
    root is the max number in the array and the left subtree will start with the max number of the subarray to the left of the
    original max number. Same goes for the right tree. I created an array for each side of the max number and sorted them in order
    to form the left and right subtree.
    Example: original array = [3,2,1,6,0,5] the max number is 6 and the sorted left subarray is [1,2,3] and sorted right subarray
    is [0,5];
    */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int[] clone = new int[nums.length];
        for (int i = 0; i < clone.length; i++) {
            clone[i] = nums[i];
        }

        Arrays.sort(clone);

        int max = clone[clone.length - 1];
        int maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                maxIndex = i;
            }
        }

        int[] leftArr = new int[maxIndex];
        int[] rightArr = new int[nums.length - maxIndex - 1];

        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = nums[i];
        }

        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = nums[maxIndex + 1 + i];
        }

        Arrays.sort(leftArr);
        Arrays.sort(rightArr);

        TreeNode root = new TreeNode(max);

        root.left = leftMaxTree(leftArr, 0, leftArr.length - 1);
        root.right = rightMaxTree(rightArr, 0, rightArr.length - 1);

        return root;
    }

    public TreeNode leftMaxTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode node = new TreeNode(nums[right]);
        node.right = leftMaxTree(nums, left, right - 1);

        return node;
    }

    public TreeNode rightMaxTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode node = new TreeNode(nums[right]);
        node.left = leftMaxTree(nums, left, right - 1);

        return node;
    }
}
