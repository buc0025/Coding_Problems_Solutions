package BinaryHeaps;
/*
https://www.techiedelight.com/find-kth-largest-element-array/
Given an array and positive integer k, find K'th largest element in the array
 */

public class FindKthLargest {
    //**************min Heap*************
    public static int findLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int n : nums) {
            queue.add(n);
        }

        for (int i = nums.length; i > k ; i--) {
            queue.poll();
        }

        return queue.peek();
    }

    //************max Heap***************
    public static int findLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int n : nums) {
            queue.add(n);
        }

        for (int i = 0; i < k - 1 ; i++) {
            queue.poll();
        }

        return queue.peek();
    }
}
