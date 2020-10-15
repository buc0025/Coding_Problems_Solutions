package Maps_Sets_Tables;
/*
https://leetcode.com/problems/single-number-iii/
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly
twice. Find the two elements that appear only once. You can return the answer in any order.

Follow up: Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int[] result = new int[2];
        int index = 0;

        for (int n : nums) {
            if (map.get(n) == 1) {
                result[index] = n;
                index++;
            }
        }
        return result;
    }
}
