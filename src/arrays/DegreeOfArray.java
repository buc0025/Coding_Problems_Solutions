package arrays;
/*
https://leetcode.com/problems/degree-of-an-array/
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of
its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 */

public class DegreeOfArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // Keeps track of occurrences for each element in array

        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        int maxFreq = 0;

        // Finding the max occurrence of an element in array
        for (int m : map.values()) {
            maxFreq = Math.max(m, maxFreq);
        }

        Set<Integer> set = new HashSet<>();

        // Set holds the elements with the most occurrences in array
        for (int m : map.keySet()) {
            if (map.get(m).equals(maxFreq)) {
                set.add(m);
            }
        }

        int ans = nums.length; // Largest possible answer to start out with

        for (int s : set) {
            int front = 0;
            int back = 0;
            // Looking for when element first appears in array
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == s) {
                    front = i;
                    break;
                }
            }
            // Looking for when element last appears in array
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == s) {
                    back = i;
                    break;
                }
            }
            ans = Math.min(ans, back - front); // Keeps track of smallest substring
        }

        return ans + 1; // Add one since index starts at 0
    }
}
