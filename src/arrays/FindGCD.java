package arrays;
/*
https://leetcode.com/problems/find-greatest-common-divisor-of-array/
Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 */

public class FindGCD {

    public int findGCD(int[] nums) {
        int min = 1000;
        int max = 1;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            }

            if (nums[i] >= max) {
                max = nums[i];
            }
        }

        for (int i = 1; i <= min; i++) {
            if (max % i == 0 && min % i == 0) {
                result = i;
            }
        }

        return result;
    }
}
