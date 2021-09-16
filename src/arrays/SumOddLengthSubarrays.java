package arrays;
/*
https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.

A subarray is a contiguous subsequence of the array.

Return the sum of all odd-length subarrays of arr.
 */

public class SumOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int len = 1;
            for (int j = i; j < arr.length; j++) {
                if (len % 2 != 0) {
                    for (int k = i; k <= j; k++) {
                        count += arr[k];
                    }
                }
                len++;
            }
        }

        return count;
    }
}
