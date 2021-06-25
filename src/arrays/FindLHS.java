package arrays;
/*
https://leetcode.com/problems/longest-harmonious-subsequence/
We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.

A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order
of the remaining elements.
 */

public class FindLHS {

    /*
    Incorrect solution. The idea is to keep track of 3 different integers. If 2 of the integers has a difference of only 1 then
    those are my current and next variables.
     */
    public int findLHS(int[] nums) {
        Arrays.sort(nums);

        int curr = nums[0];
        int next = 0;
        int currCount = 0;
        int nextCount = 0;
        int total = 0;
        int prev = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == curr) {
                currCount++;
            }
            else if (nums[i] == curr + 1) {
                next = nums[i];

                if (prev != curr || prev != next) {
                    nextCount = 0;
                    prev = curr;
                }
                nextCount++;
                curr = nums[i];
            } else {
                curr = nums[i];
                nextCount = 0;
                currCount = 0;
                currCount++;
            }

            if (currCount > 0 && nextCount > 0) {
                total = Math.max(total, currCount + nextCount);
            }
        }

        return total;
    }
}
