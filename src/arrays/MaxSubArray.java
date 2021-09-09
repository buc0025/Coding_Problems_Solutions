package arrays;
/*
https://leetcode.com/problems/maximum-subarray/
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return
its sum.

A subarray is a contiguous part of an array.
 */

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int start = 0;
            for (int j = i; j < nums.length; j++) {
                if (start + nums[j] >= max) {
                    max = start + nums[j];
                }
                start += nums[j];
            }
        }

        return max;
    }
}
