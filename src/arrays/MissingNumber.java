package arrays;
/*
https://leetcode.com/problems/missing-number/
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is
missing from the array.
 */

public class MissingNumber {

    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }

    public int missingNumber(int[] nums) {
        // Created array that can hold elements 0 - n
        int[] arr = new int[nums.length + 1];

        // Fill the index with 1 if it's in the given nums array
        for (int a : nums) {
            ++arr[a];
        }

        // Index that is not filled is the missing number
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
