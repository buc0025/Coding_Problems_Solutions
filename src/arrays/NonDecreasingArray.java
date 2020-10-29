package arrays;
/*
https://leetcode.com/problems/non-decreasing-array/
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 */

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] == nums[right]) {
                left++;
            }
            if (nums[left] > nums[right]) {
                left++;
                count++;
            } else {
                right--;
            }
        }
        return count <= 1;
    }
}
