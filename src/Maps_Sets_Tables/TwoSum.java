package Maps_Sets_Tables;
import java.util.*;

/*
https://leetcode.com/problems/two-sum/
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */

public class TwoSum {

    public int[] twoSum1(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int[] sum = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                sum[0] = map.get(diff);
                sum[1] = i;
            }
            map.put(nums[i], i);
        }
        return sum;
    }

    //*****Brute Force****

    public int[] twoSum2(int[] nums, int target) {
        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index1 = i;
                    index2 = j;
                }
            }
        }
        return new int[] {index1, index2};
    }
}
