package singly_LinkedLists;

/*
https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem
You are given the pointer to the head node of a linked list and an integer to add to the list. Create a new node
with the given integer. Insert this node at the tail of the linked list and return the head node of the linked list
formed after inserting this new node.
 */

public class InsertNodeAtTail {

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

        SinglyLinkedListNode tail_node = new SinglyLinkedListNode(data);
        if (head == null) {
            return tail_node;
        }

        SinglyLinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = tail_node;

        return head;
    }

}
