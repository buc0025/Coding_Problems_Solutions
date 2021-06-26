package arrays;
/*
https://leetcode.com/problems/longest-harmonious-subsequence/
We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.

A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order
of the remaining elements.
 */

public class FindLHS {

    /*
    Such a simple solution from top discussion. Idea is to keep track of frequency of each element. If the map contains the element
    + 1, the get the values of the element and it's + 1 and add them together.
     */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int ans = 0;

        for (int m : map.keySet()) {
            if (map.containsKey(m + 1)) {
                ans = Math.max(map.get(m) + map.get(m + 1), ans);
            }
        }

        return ans;
    }

    /*
    Incorrect solution. The idea is to keep track of 3 different integers. If 2 of the integers has a difference of only 1 then
    those are my current and next variables.
     */
    public int findLHS(int[] nums) {
        Arrays.sort(nums);

        int curr = nums[0];
        int next = 0;
        int currCount = 0;
        int nextCount = 0;
        int total = 0;
        int prev = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == curr) {
                currCount++;
            }
            else if (nums[i] == curr + 1) {
                next = nums[i];

                if (prev != curr || prev != next) {
                    nextCount = 0;
                    prev = curr;
                }
                nextCount++;
                curr = nums[i];
            } else {
                curr = nums[i];
                nextCount = 0;
                currCount = 0;
                currCount++;
            }

            if (currCount > 0 && nextCount > 0) {
                total = Math.max(total, currCount + nextCount);
            }
        }

        return total;
    }
}
