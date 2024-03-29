package arrays;
/*
https://leetcode.com/problems/search-insert-position/
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index
where it would be if it were inserted in order.
 */

public class SearchInsertPosition {

    // 10/18/2022 solution
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] > target) {
                return i;
            }
        }

        return 0;
    }

    public int searchInsert(int[] nums, int target) {
        int ans = -1;
        // Iteration is if target is found in array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        // Answer should be where nums[i] is bigger than target
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                ans = i;
                break;
            }
        }

        // If target is bigger than all elements in array
        if (ans == -1) {
            return nums.length;
        } else {
            return ans;
        }
    }
}
