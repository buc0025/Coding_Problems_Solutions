package arrays;
/*
https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.

For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:

Each element of nums is in exactly one pair, and
The maximum pair sum is minimized.
Return the minimized maximum pair sum after optimally pairing up the elements.
 */

public class MinPairSum {

    // Same concept as first solution but without using built-in sort
    public int minPairSum(int[] nums) {
        int[] arr = new int[100001];

        for (int n : nums) {
            arr[n]++;
        }

        int ans = 0;
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            if (arr[l] != 0 && arr[r] != 0) {
                int sum = l + r;
                ans = Math.max(sum, ans);
                arr[l]--;
                arr[r]--;
            }
            if (arr[l] == 0) {
                l++;
            }
            if (arr[r] == 0) {
                r--;
            }
        }

        return ans;
    }

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];
            ans = Math.max(ans, sum);
            l++;
            r--;
        }

        return ans;
    }
}
