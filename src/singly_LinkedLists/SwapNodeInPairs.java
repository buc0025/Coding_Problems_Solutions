package singly_LinkedLists;
/*
https://leetcode.com/problems/swap-nodes-in-pairs/
Given a linked list, swap every two adjacent nodes and return its head.
 */

public class SwapNodeInPairs {

    // Incorrect attempt. Idea was the swap the first 2 nodes and deal with the remaining linked list.
    // This only works with linked lists with up to 4 nodes.
    public ListNode swapPairs(ListNode head) {
        // Deals with linked lists with size 0 - 1
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head;
        ListNode dummy = head;

        // Swaps the first 2 nodes
        if (head != null && head.next != null) {
            dummy = head.next.next;
            newHead = head.next;
            newHead.next = head;
            head.next = dummy;
        }

        if (dummy == null) {
            return newHead;
        }

        ListNode newDummy = dummy.next;

        while (dummy.next != null) {
            head.next = newDummy;
            dummy.next = newDummy.next;
            newDummy.next = dummy;
        }

        return newHead;
    }
}
