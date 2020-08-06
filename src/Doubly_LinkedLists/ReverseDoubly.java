package Doubly_LinkedLists;
/*
https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
You’re given the pointer to the head node of a doubly linked list. Reverse the order of the nodes in the list.
The head node might be NULL to indicate that the list is empty. Change the next and prev pointers of all the nodes so
that the direction of the list is reversed. Return a reference to the head node of the reversed list.
 */

public class ReverseDoubly {

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {

        DoublyLinkedListNode current = head;
        DoublyLinkedListNode first = null;

        while (current != null) {
            current = head.next;
            head.next = first;
            head.prev = current;
            first = head;
            head = current;
        }

        return first;

    }
}
