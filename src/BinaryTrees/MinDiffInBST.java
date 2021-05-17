package BinaryTrees;
/*
https://leetcode.com/problems/minimum-distance-between-bst-nodes/
Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes
in the tree.
 */

public class MinDiffInBST {

    // Since we're dealing with a BST, all the values should be in order when traversed from left to right.

    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list = allValues(root, list);
        int min = 100000;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) <= min) {
                min = list.get(i) - list.get(i - 1);
            }
        }

        return min;
    }

    public List<Integer> allValues(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }

        allValues(root.left, list);
        list.add(root.val);
        allValues(root.right, list);

        return list;
    }
}
