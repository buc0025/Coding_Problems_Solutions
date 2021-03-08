package arrays;
/*
https://leetcode.com/problems/longest-continuous-increasing-subsequence/
Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The
subsequence must be strictly increasing.

A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ...,
nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].
 */

public class LongestContinuousIncreasing {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int start = 0;
        int ans = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                ans = Math.max(ans, i + 1 - start);
            } else {
                start = i;
            }
        }

        return ans;
    }
}
