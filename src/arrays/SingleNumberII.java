package arrays;
/*
https://leetcode.com/problems/single-number-ii/
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once.
Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-1; i+=3) {
            if (nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return nums[nums.length -1];
    }
}
