package arrays;
/*
https://leetcode.com/problems/monotonic-array/
An array is monotonic if it is either monotone increasing or monotone decreasing.

An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j,
A[i] >= A[j].

Return true if and only if the given array A is monotonic.
 */

public class MonotonicArray {

    public boolean isMonotonic(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        boolean increase = true;
        boolean decrease = true;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < max) {
                increase = false;
            }
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > min) {
                decrease = false;
            }
        }

        return increase || decrease;
    }
}
