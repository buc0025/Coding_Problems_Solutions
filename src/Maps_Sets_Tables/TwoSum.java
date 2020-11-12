package Maps_Sets_Tables;
import java.util.*;

/*
https://leetcode.com/problems/two-sum/
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */

public class TwoSum {

********Incorrect mock interview problem that passes 76/80 test cases********
    public int[] twoSum(int[] nums, int target) {
        int index1 = -1;
        int index2 = -1;
        int diff = 0;
        Map<Integer, Integer> map = new HashMap<>();

        //Populates map keys with indices and values with elements in array
        for (int i = 0; i < nums.length; i++) {
            if (map.containsValue(target - nums[i])) {
                diff = target - nums[i];
                index1 = i;
                map.put(i, nums[i]);
                break;
            }
            map.put(i, nums[i]);
        }

        for (int m : map.keySet()) {
            if (map.get(m) == diff && m != index1) {
                index2 = m;
            }
        }

        return new int[] {index1, index2};
    }

    public int[] twoSum1(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                index1 = map.get(diff);
                index2 = i;
            }
            map.put(nums[i], i);
        }
        return new int[] {index1, index2};
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
