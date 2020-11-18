package arrays;
/*
https://leetcode.com/problems/array-partition-i/
Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such
that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
 */

public class ArrayPartition {

    public int arrayPairSum(int[] nums) {
        // Pattern shows that getting the minimum value between top 2 greatest elements return largest maximized sum
        Arrays.sort(nums);

        int max = 0;

        for (int i = 0; i < nums.length-1; i+=2) {
            max += Math.min(nums[i], nums[i + 1]);
        }

        return max;
    }
}
