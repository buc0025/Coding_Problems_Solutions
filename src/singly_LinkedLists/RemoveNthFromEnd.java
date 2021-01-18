package singly_LinkedLists;
/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;

        ListNode curr = head;

        while (curr != null) {
            len++;
            curr = curr.next;
        }

        if (len == n) {
            return head.next;
        }

        ListNode node = head;
        int slen = 1;

        while (node != null && node.next != null) {
            if (slen == len - n) {
                node.next = node.next.next;
                break;
            } else {
                node = node.next;
                slen++;
            }
        }

        return head;
    }
}
