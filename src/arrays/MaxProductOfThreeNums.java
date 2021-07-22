package arrays;
/*
https://leetcode.com/problems/maximum-product-of-three-numbers/
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
 */

public class MaxProductOfThreeNums {

    /*
    Attempt at trying to find solution without using built-in sort. Idea is to find the largest positive and negative numbers and
    return the bigger product of 2 negatives numbers multiplied by a positive versus product of top 3 largest positive numbers.
    The ocrrect given solution has similar idea but with only one loop.
     */
    public int maximumProduct(int[] nums) {
        int product = 1;

        int negatives = 0;

        for (int n : nums) {
            if (n < 0) {
                negatives++;
            }
        }

        int pos1 = -1000;
        int pos2 = -1000;
        int pos3 = -1000;
        int neg1 = 1000;
        int neg2 = 1000;
        int neg3 = 1000;

        for (int n : nums) {
            if (n > pos1) {
                pos1 = n;
            } else {
                pos2 = Math.max(pos2, n);
            }

            if (n < neg1) {
                neg1 = n;
            } else {
                neg2 = Math.min(neg2, n);
            }
        }

        int negSame = 0;
        int posSame = 0;

        for (int n : nums) {
            if (n == pos2) {
                posSame++;
            }
            if (posSame == 2) {
                pos3 = pos2;
            } else if (n < pos2){
                pos3 = Math.max(n, pos3);
            }

            if (n == neg2) {
                negSame++;
            }
            if (negSame == 2) {
                neg3 = neg2;
            } else if (n > neg2){
                neg3 = Math.min(n, neg3);
            }
        }

        if (negatives <= 1) {
            for (int i = nums.length - 1; i >= nums.length - 3; i--) {
                product *= nums[i];
            }
            return product;
        }

        int negsNpos = neg1 * neg2 * pos1;
        int posOnly = pos1 * pos2 * pos3;

        return negsNpos > posOnly ? negsNpos : posOnly;
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int negsNpos = nums[0] * nums[1] * nums[nums.length - 1];
        int posOnly = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];

        return negsNpos > posOnly ? negsNpos : posOnly;
    }
}
