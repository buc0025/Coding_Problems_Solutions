package arrays;
/*
https://leetcode.com/problems/largest-number-at-least-twice-of-others/
You are given an integer array nums where the largest integer is unique.

Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return
the index of the largest element, or return -1 otherwise.
 */

public class DominantIndex {

    public int dominantIndex(int[] nums) {
        int max = 0;
        int index = 0;

        for (int n : nums) {
            max = Math.max(max, n);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                index = i;
                break;
            }
        }

        for (int n : nums) {
            if (n != max && max < n * 2) {
                return -1;
            }
        }

        return index;
    }
}
