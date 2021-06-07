package singly_LinkedLists;
/*
Mock interview question from Jason on 6/6/2021. Delete every other node from circular linked list starting from the head. Return
linked list after deleting every other node.

Follow up question: Delete every nth node from circular linked list.
 */

public class DeleteNodeCircular {
    
    public static ListNode everyOther(ListNode head, int n) {
        ListNode dummy = head;
        dummy.next = head.next.next;

        while (dummy != head || dummy.next != head) {
            dummy.next = dummy.next.next;
        }

        return head;
    }
}
