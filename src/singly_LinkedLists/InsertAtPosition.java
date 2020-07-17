package singly_LinkedLists;

/*
https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem
You’re given the pointer to the head node of a linked list, an integer to add to the list and the position at which
the integer must be inserted. Create a new node with the given integer, insert this node at the desired position and
return the head node. A position of 0 indicates head, a position of 1 indicates one node away from the head and so on.
*/

public class InsertAtPosition {

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

        SinglyLinkedListNode prev = head;
        SinglyLinkedListNode new_node = new SinglyLinkedListNode(data);
        int count = 0;

        if (position == 0) {
            new_node.next = head;
            return new_node;
        }

        while (count < position -1) {
            prev = prev.next;
            count++;
        }

        SinglyLinkedListNode next_node = prev.next;
        prev.next = new_node;
        new_node.next = next_node;

        return head;
    }

}
