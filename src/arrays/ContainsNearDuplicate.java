package arrays;
/*
https://leetcode.com/problems/contains-duplicate-ii/submissions/
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that
nums[i] == nums[j] and abs(i - j) <= k.
 */

public class ContainsNearDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 1) {
            return false;
        }

        int max = k + 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    max = Math.min(j - i, max);
                }
            }
        }

        return max <= k;
    }
}
