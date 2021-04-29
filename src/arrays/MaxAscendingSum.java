package arrays;
/*
https://leetcode.com/problems/maximum-ascending-subarray-sum/
Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.

A subarray is defined as a contiguous sequence of numbers in an array.

A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi < numsi+1. Note that a subarray
of size 1 is ascending.
 */

public class MaxAscendingSum {

    public int maxAscendingSum(int[] nums) {
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i; j < nums.length-1; j++) {

                if (nums[j + 1] > nums[j]) {
                    sum += nums[j + 1];
                    max = Math.max(sum, max);
                } else {
                    sum = 0;
                }
            }
        }
        return max;
    }
}
