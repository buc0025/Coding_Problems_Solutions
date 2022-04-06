package arrays;
/*
https://leetcode.com/problems/partition-array-according-to-given-pivot/

You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are
satisfied:

Every element less than pivot appears before every element greater than pivot.
Every element equal to pivot appears in between the elements less than and greater than pivot.
The relative order of the elements less than pivot and the elements greater than pivot is maintained.
More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth
element. For elements less than pivot, if i < j and nums[i] < pivot and nums[j] < pivot, then pi < pj. Similarly for elements
greater than pivot, if i < j and nums[i] > pivot and nums[j] > pivot, then pi < pj.
Return nums after the rearrangement.
 */

public class PivotArray {

    // 4/5/2022 solution
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lessThanPivot = new ArrayList<>();
        List<Integer> greaterThanPivot = new ArrayList<>();
        int numOfPivots = 0;
        int[] result = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            if (num < pivot) {
                lessThanPivot.add(num);
            } else if (num > pivot) {
                greaterThanPivot.add(num);
            } else {
                numOfPivots++;
            }
        }

        for (int num : lessThanPivot) {
            result[index] = num;
            index++;
        }

        for (int i = 0; i < numOfPivots; i++) {
            result[index] = pivot;
            index++;
        }

        for (int num : greaterThanPivot) {
            result[index] = num;
            index++;
        }

        return result;
    }
}
