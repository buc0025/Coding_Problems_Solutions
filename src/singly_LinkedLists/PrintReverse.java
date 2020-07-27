package singly_LinkedLists;
import java.util.*;
/*
https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
You are given the pointer to the head node of a linked list and you need to print all its elements in reverse order
from tail to head, one element per line. The head pointer may be null meaning that the list is empty - in that case,
do not print anything!
 */

public class PrintReverse {

    static void reversePrint(SinglyLinkedListNode head) {

        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode current = head;

        if (head == null) {
            return;
        }
        while (current != null) {
            head = head.next;
            current.next = prev;
            prev = current;
            current = head;
        }

        while (prev != null) {
            System.out.println(prev.data);
            prev = prev.next;
        }
    }

}
