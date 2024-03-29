package arrays;
/*
https://leetcode.com/problems/concatenation-of-array/
Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and
ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.

Return the array ans.
 */

public class GetConcatenation {

    //  3/24/2022 solution
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len * 2];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i >= len) {
                arr[i] = nums[index++];
            } else {
                arr[i] = nums[i];
            }
        }

        return arr;
    }

    public int[] getConcatenation(int[] nums) {
        int[] arr = new int[nums.length * 2];
        int index = 0;


        for (int i = 0; i < arr.length; i++) {
            if (i < nums.length) {
                arr[i] = nums[i];
            } else {
                arr[i] = nums[index];
                index++;
            }
        }

        return arr;
    }

    public int[] getConcatenation(int[] nums) {
        int[] arr = new int[nums.length * 2];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i >= nums.length) {
                arr[i] = nums[index];
                index++;
            } else {
                arr[i] = nums[i];
            }
        }

        return arr;
    }
}
