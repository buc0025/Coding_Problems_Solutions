package arrays;
/*
https://leetcode.com/problems/valid-mountain-array/

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 */

public class ValidMountainArray {

    // 9/23/2022 solution
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int max = -1;
        int peakIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                peakIndex = i;
            }
        }

        if (peakIndex == arr.length - 1 || peakIndex == 0) {
            return false;
        }

        for (int i = 1; i < peakIndex; i++) {
            if (arr[i] <= arr[i - 1]) {
                return false;
            }
        }

        for (int i = peakIndex; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
