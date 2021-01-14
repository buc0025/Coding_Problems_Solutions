package BinaryTrees;
/*
https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node
never differ by more than 1.
 */

public class LinkedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        nodeToList(head, list);

        return helper(list, 0, list.size()-1);
    }

    public TreeNode helper(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = helper(list, left, mid - 1);
        node.right = helper(list, mid + 1, right);

        return node;
    }

    public void nodeToList(ListNode head, List<Integer> list) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    // Idea was taken from solution forming BST from sorted array
    public TreeNode sortedListToBST(ListNode head) {
        int[] arr = turnToArray(head);
        return turnToBST(arr, 0, arr.length - 1);
    }

    public TreeNode turnToBST(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }
        // Treat like Binary search to assign node as middle
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = turnToBST(arr, left, mid - 1);
        node.right = turnToBST(arr, mid + 1, right);

        return node;
    }

    public int[] turnToArray(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] arr = new int[list.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
