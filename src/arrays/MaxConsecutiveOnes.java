package arrays;
/*
https://leetcode.com/problems/max-consecutive-ones/
Given a binary array nums, return the maximum number of consecutive 1's in the array.
 */

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int reset = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                reset++;
                max = Math.max(max, reset);
            } else {
                reset = 0;
            }
        }

        return max;
    }
}
