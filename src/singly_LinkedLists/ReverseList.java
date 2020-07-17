package singly_LinkedLists;

/*
https://leetcode.com/problems/reverse-linked-list/
Reverse a singly linked list.
 */

public class ReverseList {

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {

            current = current.next;
            head.next = prev;
            prev = head;
            head = current;
        }
        return prev;
    }

}
