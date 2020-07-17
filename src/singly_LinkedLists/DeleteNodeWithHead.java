package singly_LinkedLists;

/*
https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
You’re given the pointer to the head node of a linked list and the position of a node to delete. Delete the node at the given position and return the head node.
A position of 0 indicates head, a position of 1 indicates one node away from the head and so on. The list may become empty after you delete the node.
 */

public class DeleteNodeWithHead {

    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {

        if (position == 0) {
            head = head.next;
            return head;
        }
        SinglyLinkedListNode current = head;
        int count = 0;

        while (count < position-1) {
            current = current.next;
            count++;
        }

        current.next = current.next.next;

        return head;
    }

}
