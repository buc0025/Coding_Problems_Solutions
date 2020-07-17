package singly_LinkedLists;

/*
https://www.hackerrank.com/challenges/compare-two-linked-lists/problem?h_r=next-challenge&h_v=legacy
You’re given the pointer to the head nodes of two linked lists. Compare the data in the nodes of the linked lists to
check if they are equal. The lists are equal only if they have the same number of nodes and corresponding nodes contain
the same data. Either head pointer given may be null meaning that the corresponding list is empty.
 */

public class ComparingLinkedLists {

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1 == head2;

    }

}
