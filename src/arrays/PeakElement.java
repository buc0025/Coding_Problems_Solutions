package arrays;
/*
https://leetcode.com/problems/find-peak-element/
A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index
to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.
 */

public class PeakElement {

    // Problem calls to complete with logarithmic complexity but solved in O(n) time
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int ans = -1;

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && i != nums.length-1) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])  {
                    ans = i;
                }
            }
            if (i == 0 && nums.length > 1 && nums[0] > nums[1]) {
                ans = i;
            }
            if (i == nums.length - 1 && nums.length > 1 && nums[i] > nums[i - 1]) {
                ans = i;
            }
        }
        return ans;
    }
}
