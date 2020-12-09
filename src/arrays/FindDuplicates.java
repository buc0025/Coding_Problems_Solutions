package arrays;
/*
https://leetcode.com/problems/find-all-duplicates-in-an-array/
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?
 */

public class FindDuplicates {

    // Had to look at solution and study it
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            // If element is negative, it means that index has been visited before
            if (nums[index] < 0) {
                list.add(index + 1);
            }
            // Turn element to negative
            nums[index] *= -1;
        }

        return list;
    }

    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int n : nums ) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        for (int m : map.keySet()) {
            if (map.get(m) == 2) {
                list.add(m);
            }
        }
        return list;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}
