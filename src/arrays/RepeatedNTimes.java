package arrays;
/*
https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

Return the element repeated N times.
 */

public class RepeatedNTimes {

    public int repeatedNTimes(int[] arr) {
        int n = arr.length/2;
        int ans = -1;

        int[] nums = new int[10000];

        for (int i = 0; i < arr.length; i++) {
            ++nums[arr[i]];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}
