package arrays;
/*
https://leetcode.com/problems/maximum-average-subarray-i/
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a
calculation error less than 10-5 will be accepted.
 */

public class MaxAverageSubarray {

    // New sliding window technique learned from given solution
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double max = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(sum, max);
        }

        return max / k;
    }

    /*
    Passes 116/127 test cases but doesn't work for {-1} and k = 1. Given solution gives a new sliding window technique that
    doesn't use a double for loop but instead uses 2 loops. First loop sums all elements from beginning to k. The second loop
    starts from k to end of array. The sum is tracked by subtracting current element and nums[i-k] (first element of last loop)
     */
    public double findMaxAverage(int[] nums, int k) {
        double result = Double.MIN_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {
            double max = 0;
            for (int j = i; j < i + k; j++) {
                max += nums[j];
            }
            result = Math.max(max, result);
        }

        return result/k;
    }
}
