package arrays;
/*
https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
You are given an array nums of non-negative integers. nums is considered special if there exists a number x such that there are
exactly x numbers in nums that are greater than or equal to x.

Notice that x does not have to be an element in nums.

Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.
 */

public class SpecialArray {
    /*
    First thought about using a map to find of the occurrence of each element in array but that would require extra space. Then
    thought about creating another array to record the number of occurrence instead but that requires extra space and time as well.
     */

    public int specialArray(int[] nums) {
        int count = 0;

        int n = 1;

        while (n <= nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= n) {
                    count++;
                }
            }
            if (count == n) {
                break;
            } else {
                n++;
                count = 0;
            }
        }

        return count != 0 ? count : -1;
    }
}
