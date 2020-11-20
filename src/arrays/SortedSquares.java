package arrays;
/*
https://leetcode.com/problems/squares-of-a-sorted-array/
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in
sorted non-decreasing order.
 */

public class SortedSquares {

    // Done this problem previous but was never committed. Old solution used built-in Arrays.sort
    public int[] sortedSquares(int[] arr) {
        int[] nums = new int[arr.length];
        int arrLeft = 0;
        int arrRight = arr.length - 1;
        int numsEnd = nums.length - 1;

        while (arrLeft <= arrRight) {
            // Comparing the left and right elements of given array
            if (Math.abs(arr[arrLeft]) >= Math.abs(arr[arrRight])) {
                nums[numsEnd] = arr[arrLeft] * arr[arrLeft];
                arrLeft++;
            } else {
                nums[numsEnd] = arr[arrRight] * arr[arrRight];
                arrRight--;
            }
            numsEnd--;
        }

        return nums;
    }
}
