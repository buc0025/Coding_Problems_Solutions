package singly_LinkedLists;
/*
https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end
(the list is 1-indexed).
 */

public class SwapNodes {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode first = head;
        ListNode second = head;

        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }

        first = fast;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        second = slow;

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}
