package arrays;
/*
https://leetcode.com/problems/maximum-product-of-three-numbers/
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
 */

public class MaxProductOfThreeNums {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int negsNpos = nums[0] * nums[1] * nums[nums.length - 1];
        int posOnly = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];

        return negsNpos > posOnly ? negsNpos : posOnly;
    }
}
