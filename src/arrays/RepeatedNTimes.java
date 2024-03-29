package arrays;
/*
https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

Return the element repeated N times.
 */

public class RepeatedNTimes {

    // 10/7/2022 solution
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        int[] arr = new int[10000];

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                return i;
            }
        }

        return 0;
    }

    // 10/7/2022 solution
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) == n) {
                return key;
            }
        }

        return 0;
    }

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
