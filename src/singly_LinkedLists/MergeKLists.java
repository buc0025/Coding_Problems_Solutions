package singly_LinkedLists;
/*
https://leetcode.com/problems/merge-k-sorted-lists/
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
 */

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (ListNode list : lists) {
            while (list != null) {
                queue.add(list.val);
                list = list.next;
            }
        }

        ListNode head = new ListNode(-1);
        ListNode runner = head;

        while (!queue.isEmpty()) {
            runner.next = new ListNode(queue.poll());
            runner = runner.next;
        }

        return head.next;
    }
}
