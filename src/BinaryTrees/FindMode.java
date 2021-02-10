package BinaryTrees;
/*
https://leetcode.com/problems/find-mode-in-binary-search-tree/
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 */

public class FindMode {

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[] {};
        }
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        if (list.size() == 1) {
            return new int[] {list.get(0)};
        }


        int max = 1;
        int max1 = 1;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(list.get(0), 1);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1)) {
                max++;
            } else {
                max = 1;
            }
            max1 = Math.max(max, max1);

            if (map.containsKey(list.get(i))) {
                map.put(list.get(i), map.get(list.get(i)) + 1);
            } else {
                map.put(list.get(i), 1);
            }
        }

        int size = 0;
        for (int m : map.keySet()) {
            if (map.get(m) == max1) {
                size++;
            }
        }

        int[] arr = new int[size];
        int index = 0;
        for (int m : map.keySet()) {
            if (map.get(m) == max1) {
                arr[index] = m;
                index++;
            }
        }

        return arr;
    }

    public void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
