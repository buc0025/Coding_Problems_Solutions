package arrays;
/*
https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

Given an array of integers nums and a positive integer k, check whether it is possible to divide this array into sets of k
consecutive numbers.

Return true if it is possible. Otherwise, return false.
 */

public class IsPossibleDivide {

    // 8/9/2022 Unfinished solution
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        int sets = nums.length / k;

        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int prev = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == prev + 1) {
                    prev = nums[j];
                    nums[j] *= -1;
                    count++;
                }
                if (count == k) {
                    sets--;
                    break;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int neg = 1;
            int prev = nums[i];
            if (prev < 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < 0) {
                    continue;
                }
                if (nums[j] == prev - 1) {
                    prev = nums[j];
                    nums[j] *= -1;
                    neg++;
                }
                if (neg == k) {
                    sets--;
                    break;
                }
            }
        }

        return sets == 0;
    }
}
