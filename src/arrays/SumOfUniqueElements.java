package arrays;
/*
https://leetcode.com/problems/sum-of-unique-elements/
You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.

Return the sum of all the unique elements of nums.
 */

public class SumOfUniqueElements {

    // First thought was to use a map but that uses extra space. The constraints was that 1 <= nums[i] <= 100 so I used an arr to
    // keep track on frequency
    public int sumOfUnique(int[] nums) {
        int[] arr = new int[101];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                sum += i;
            }
        }

        return sum;
    }

    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int sum = 0;

        for (int m : map.keySet()) {
            if (map.get(m) == 1) {
                sum += m;
            }
        }

        return sum;
    }
}
