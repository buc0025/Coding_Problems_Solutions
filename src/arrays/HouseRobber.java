package arrays;
/*
https://leetcode.com/problems/house-robber/
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only
constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically
contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you
can rob tonight without alerting the police.
 */

public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] arr = new int[nums.length];

        arr[0] = nums[0];
        arr[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] + arr[i - 2] > arr[i - 1]) {
                arr[i] = nums[i] + arr[i - 2];
            } else {
                arr[i] = arr[i - 1];
            }
        }

        return arr[arr.length - 1];
    }
}
