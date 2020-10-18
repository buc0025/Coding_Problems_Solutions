package BinaryHeaps;
/*
https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/

Given two integer arrays of equal length target and arr.
In one step, you can select any non-empty sub-array of arr and reverse it. You are allowed to make any number of steps.
Return True if you can make arr equal to target, or False otherwise.
 */

public class TwoEqualArrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();

        for (int a : arr) {
            queue.add(a);
        }

        for (int t : target) {
            queue2.add(t);
        }

        while (!queue.isEmpty()) {
            int n = queue.poll();
            if (n != queue2.peek()) {
                return false;
            } else {
                queue2.poll();
            }
        }
        return true;
    }

    public boolean canBeEqual(int[] target, int[] arr) {

        Arrays.sort(target);
        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (target[i] == arr[i]) {
                count++;
            }
        }
        return count == target.length;
    }
}
