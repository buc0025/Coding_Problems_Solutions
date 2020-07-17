package singly_LinkedLists;

/*
https://leetcode.com/problems/palindrome-linked-list/
Given a singly linked list, determine if it is a palindrome.
My initial thought was to make a copy of the linked list and reverse to compare with the original.
*/

public class Palindrome {

    public boolean isPalindrome(ListNode head) {


        ListNode new_copy = copy(head);
        ListNode prev = reverse(new_copy);

        while (head != null && prev != null) {
            if (head.val != prev.val) {
                return false;
            }

            head = head.next;
            prev = prev.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next_node = null;

        while (current != null) {
            next_node = current.next;
            current.next = prev;
            prev = current;
            current = next_node;
        }
        return prev;
    }

    public ListNode copy(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode headOfCopy = new ListNode(head.val);
        ListNode current = headOfCopy;
        head = head.next;

        while (head != null) {
            current.next = new ListNode(head.val);
            head = head.next;
            current = current.next;
        }
        return headOfCopy;
    }


}
