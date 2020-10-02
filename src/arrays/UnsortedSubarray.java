package arrays;
/*
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.
 */

public class UnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] clone = new int[nums.length];
        int index = 0;
        // Creating a clone of original array before sort to compare with sorted array
        for (int n : nums) {
            clone[index] = n;
            index++;
        }

        Arrays.sort(nums);

        int start = 0;
        int end = 0;

        // Find the first index where unsorted and sorted array don't match
        for (int i = 0; i < nums.length; i++) {
            if (clone[i] != nums[i]) {
                start = i;
                break;
            }
        }
        // Find the last index where unsorted and sorted array don't match
        for (int i = nums.length -1 ; i >= 0; i--) {
            if (clone[i] != nums[i]) {
                end = i;
                break;
            }
        }
        // Subtracting end and start to find length of unsorted continuous subarray
        if (end - start == 0) {
            return 0;
        } else {
            return end - start + 1;
        }
    }
}
