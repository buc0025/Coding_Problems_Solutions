package BinaryTrees;
/*
https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level X such that the sum of all the values of nodes at level X is maximal.
 */

public class MaxLevelSumOfBT {

    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int levelSum = 0; // calculates the sum of each level
        int level = 0; // keeps track of the level we're on
        int maxLevel = 0; // returns the level with the greatest sum

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                levelSum += node.val;
            }

            if (node == null && queue.peek() == null) {
                break;
            }

            // Reached the end of a level
            if (queue.peek() == null) {
                level++;
                // Assigning new max level if max sum of level is greater than previous ones
                if (levelSum > max) {
                    maxLevel = level;
                }
                max = Math.max(max, levelSum);
                levelSum = 0;
                queue.add(null);
            }
        }

        return maxLevel;
    }
}
