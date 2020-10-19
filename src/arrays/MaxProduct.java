package arrays;
/*
https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
Given the array of integers nums, you will choose two different indices i and j of that array.
Return the maximum value of (nums[i]-1)*(nums[j]-1).
 */

public class MaxProduct {

    public int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;

        for (int n : nums) {
            if (n > max1) {
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max2 = n;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }

    public int maxProduct(int[] nums) {
        int min1 = Integer.MIN_VALUE;
        int min2 = Integer.MIN_VALUE;
        int index = -1;
        int index2 = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= min1) {
                index = i;
                min1 = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= min2 && i != index) {
                index2 = i;
                min2 = nums[i];
            }
        }

        return (nums[index]-1) * (nums[index2] -1);

    }
}
//*************OLD SOLUTION with O(n log n) runtime***********
//Arrays.sort(nums);
//return (nums[nums.length-1] - 1) * (nums[nums.length-2] - 1);