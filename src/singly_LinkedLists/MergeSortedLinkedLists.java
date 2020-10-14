package singly_LinkedLists;
/*
https://leetcode.com/problems/merge-two-sorted-lists/
Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
 */

public class MergeSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        ListNode current = null;

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current = l1;
                l1 = current.next;
            } else {
                current = l2;
                l2 = current.next;
            }
        }

        newHead = current;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                current = l1;
                l1 = current.next;
            } else {
                current.next = l2;
                current = l2;
                l2 = current.next;
            }
        }

        while (l1 != null) {
            current.next = l1;
            current = l1;
            l1 = current.next;
        }

        while (l2 != null) {
            current.next = l2;
            current = l2;
            l2 = current.next;
        }
        return newHead;
    }
}
