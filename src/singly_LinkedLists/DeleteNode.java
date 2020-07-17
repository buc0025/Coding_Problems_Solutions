package singly_LinkedLists;

/*
https://leetcode.com/problems/delete-node-in-a-linked-list/
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }

}
