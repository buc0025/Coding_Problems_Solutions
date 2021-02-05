package singly_LinkedLists;
/*
https://leetcode.com/problems/intersection-of-two-linked-lists/
Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class IntersectionTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headb = headB;
        ListNode heada = headA;

        while (headA != headB) {
            if (headA == null) {
                headA = headb;
            } else {
                headA = headA.next;
            }
            if (headB == null) {
                headB = heada;
            } else {
                headB = headB.next;
            }
        }

        return headA;
    }

    // Incorrect solution, should've used else statements for assigning heads to head.next
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode aTrail = headA;
        ListNode bTrail = headB;

        while (aTrail != bTrail) {
            if (aTrail == null) {
                aTrail = headB;
            }

            if (bTrail == null) {
                bTrail = headA;
            }
            aTrail = aTrail.next;
            bTrail = bTrail.next;
        }

        return aTrail;
    }

    // Incorrect attempt. Idea was to get the length of both lists and make them the same length so they'll intersect at the
    // same time if they do intersect.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = 0;
        int bLen = 0;

        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != null) {
            aLen++;
            currA = currA.next;
        }

        while (currB != null) {
            bLen++;
            currB = currB.next;
        }

        if (aLen > bLen) {
            aLen = aLen - bLen;
            while (aLen > 0) {
                headA = headA.next;
                aLen--;
            }
        }

        if (aLen < bLen) {
            bLen = bLen - aLen;
            while (bLen > 0) {
                headB = headB.next;
                bLen--;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

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
