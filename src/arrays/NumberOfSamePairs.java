package arrays;
/*
https://leetcode.com/problems/number-of-good-pairs/
Given an array of integers nums.

A pair (i,j) is called good if nums[i] == nums[j] and i < j.

Return the number of good pairs.
 */

public class NumberOfSamePairs {

    public int numIdenticalPairs(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
