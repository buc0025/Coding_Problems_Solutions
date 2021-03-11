package arrays;
/*
https://leetcode.com/problems/find-pivot-index/
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the
numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies
to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.
 */

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int index = -1;
        int sum = 0;

        for (int n : nums) {
            sum += n;
        }

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            int rightSum = sum - nums[i];

            // Comparing leftSum and rightSum without current index
            if (leftSum - nums[i] == rightSum / 2 && rightSum % 2 == 0) {
                index = i;
                break;
            }
        }

        return index;
    }

    public int pivotIndex(int[] nums) {
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int l = 0; l < i; l++) {
                leftSum += nums[l];
            }

            for (int r = nums.length - 1; r > i; r--) {
                rightSum += nums[r];
            }

            // Break out for leftmost pivot index
            if (leftSum == rightSum) {
                index = i;
                break;
            }
        }

        return index;
    }
}
