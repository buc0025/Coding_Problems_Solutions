package BinaryTrees;
/*
https://leetcode.com/problems/minimum-absolute-difference-in-bst/
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 */

public class MinimumDifference {

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(list.get(i + 1) - list.get(i), min);
        }
        return min;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < list.size(); i++) {
            if (Math.abs(list.get(i) - list.get(i - 1)) <= min) {
                min = Math.abs(list.get(i) - list.get(i - 1));
            }
        }

        return min;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inOrder(root, nodes);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i +1; j < nodes.size(); j++) {
                if (Math.abs(nodes.get(i) - nodes.get(j)) < min) {
                    min = Math.abs(nodes.get(i) - nodes.get(j));
                }
            }
        }
        return min;
    }

    public void inOrder(TreeNode root, List list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
