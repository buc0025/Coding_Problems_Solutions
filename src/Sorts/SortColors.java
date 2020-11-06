package Sorts;
/*
https://leetcode.com/problems/sort-colors/
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are
adjacent, with the colors in the order red, white, and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */

public class SortColors {

    public void sortColors(int[] nums) {
        // Used bubble sort
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] >= nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}
