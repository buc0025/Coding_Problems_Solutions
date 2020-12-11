package singly_LinkedLists;
/*
https://leetcode.com/problems/merge-in-between-linked-lists/
You are given two linked lists: list1 and list2 of sizes n and m respectively.
Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
 */

public class MergeInBetween {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode current = list1;
        ListNode list2Clone = list2;

        // Looking for the second half of list1
        for (int i = 0; i <= b; i++) {
            current = current.next;
        }

        // Looking for the end of list2 to attach second half of list1 to it
        while (list2Clone.next != null) {
            list2Clone = list2Clone.next;
        }

        list2Clone.next = current;

        ListNode list1Clone = list1;

        // Looking for end of first half of list1 to attach new list2 to it
        for (int i = 1; i < a; i++) {
            list1Clone = list1Clone.next;
        }

        list1Clone.next = list2;

        return list1;
    }
}
