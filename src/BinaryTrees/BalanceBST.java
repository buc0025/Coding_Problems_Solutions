package BinaryTrees;
/*
https://leetcode.com/problems/balance-a-binary-search-tree/
Given a binary search tree, return a balanced binary search tree with the same node values.

A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.

If there is more than one answer, return any of them.
 */

public class BalanceBST {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int[] arr = listToArray(list);

        return arrToBST(arr, 0, arr.length - 1);
    }

    public TreeNode arrToBST(int[] arr, int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = arrToBST(arr, l, mid -1);
        root.right = arrToBST(arr, mid + 1, r);

        return root;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public int[] listToArray(List<Integer> list) {
        int[] arr = new int[list.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
