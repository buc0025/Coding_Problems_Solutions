package singly_LinkedLists;

/*
https://leetcode.com/problems/remove-linked-list-elements/
Remove all elements from a linked list of integers that have value val.
 */

public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode current = head;

        while (head != null && head.val == val) {
            head = head.next;
        }

        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

}
