package singly_LinkedLists;

/*
https://leetcode.com/problems/palindrome-linked-list/
Given a singly linked list, determine if it is a palindrome.
My initial thought was to make a copy of the linked list and reverse to compare with the original.
*/

public class Palindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseHalf = null;
        ListNode curr = slow;

        while (curr != null) {
            curr = curr.next;
            slow.next = reverseHalf;
            reverseHalf = slow;
            slow = curr;
        }

        while (reverseHalf != null) {
            if (reverseHalf.val != head.val) {
                return false;
            }
            reverseHalf = reverseHalf.next;
            head = head.next;
        }

        return true;
    }

    // Incorrect attempt. Not sure why this doesn't work since I'm comparing the reverse with the original
    // Works correctly for 1->2->3->3 but not 1->2->1->1
    public boolean isPalindrome(ListNode head) {
        ListNode reverse = reverse(head);

        while (head != null && reverse != null) {
            if (head.val != reverse.val) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            current = current.next;
            head.next = prev;
            prev = head;
            head = current;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Using slow pointer to find the middle of the LinkedList
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reversing the middle of the LinkedList
        ListNode rev = reverse(slow);
        // Comparing first half of the LinkedList to reversed half
        while (head != slow) {
            if (head.val != rev.val) {
                return false;
            }
            head = head.next;
            rev = rev.next;
        }
        return true;
    }
    // Returns reversed LinkedList
    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            curr = curr.next;
            head.next = prev;
            prev = head;
            head = curr;
        }
        return prev;
    }

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
