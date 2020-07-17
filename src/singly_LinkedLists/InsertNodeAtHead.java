package singly_LinkedLists;

/*
https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
Given pointer to head node, create new node with given integer and insert node at the head.
 */

public class InsertNodeAtHead {

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {

        SinglyLinkedListNode new_node = new SinglyLinkedListNode(data);

        new_node.next = head;

        return new_node;
    }

}


