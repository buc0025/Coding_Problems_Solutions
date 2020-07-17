package singly_LinkedLists;

/*
https://leetcode.com/problems/middle-of-the-linked-list/
Given a non-empty, singly linked list with head node head, return a middle node of linked list.
If there are two middle nodes, return the second middle node.
 */

public class MiddleNode {

    public ListNode middleNode(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (head != null && head.next != null) {
            slow = slow.next;
            fast = head.next.next;
            head = fast;
        }
        return slow;
    }

}
