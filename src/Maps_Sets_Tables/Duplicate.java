package Maps_Sets_Tables;
import java.util.*;

/*
https://leetcode.com/problems/contains-duplicate/
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */

public class Duplicate {

    public boolean containsDuplicate1(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size() != nums.length;
    }

    public boolean containsDuplicate2(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int a : nums) {
            if (map.containsKey(a)) {
                return true;
            } else {
                map.put(a, 1);
            }
        }
        return false;
    }

    public boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}
