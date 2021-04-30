package arrays;
/*
https://leetcode.com/problems/move-zeroes/
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
 */

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();

        for (int n : nums) {
            queue.add(n);
        }

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (queue.peek() == 0) {
                queue.poll();
                queue.add(0);
            } else {
                nums[index] = queue.poll();
                index++;
            }
        }

        for (int i = nums.length -  queue.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
