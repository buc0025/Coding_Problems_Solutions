package singly_LinkedLists;
/*
https://leetcode.com/problems/intersection-of-two-linked-lists/
Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class IntersectionTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aReverse = null;
        ListNode currentA = headA;

        while (currentA != null) {
            currentA = currentA.next;
            headA.next = aReverse;
            aReverse = headA;
            headA = currentA;
        }

        ListNode bReverse = null;
        ListNode currentB = headB;

        while (currentB != null) {
            currentB = currentB.next;
            headB.next = bReverse;
            bReverse = headB;
            headB = currentB;
        }

        while (aReverse != null && bReverse != null) {
            if (aReverse == bReverse) {
                return aReverse;
            }
            aReverse = aReverse.next;
            bReverse = bReverse.next;
        }

        return null;
    }
}
