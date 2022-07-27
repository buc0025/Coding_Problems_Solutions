package arrays;
/*
https://leetcode.com/problems/largest-number-at-least-twice-of-others/
You are given an integer array nums where the largest integer is unique.

Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return
the index of the largest element, or return -1 otherwise.
 */

public class DominantIndex {

    // 7/26/2022  Top solution was to solve with 1 loop and keep track of the second biggest number and check if max is at least
    // twice its size
    public int dominantIndex(int[] nums) {
        int max = 0;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != index && max < nums[i] * 2) {
                return -1;
            }
        }

        return index;
    }

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
