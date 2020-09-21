package Maps_Sets_Tables;
/*
https://leetcode.com/problems/majority-element/
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            int i = 1;
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, i);
            }
        }

        int num = 0;
        int max = 0;

        for (int m : map.keySet()) {
            if (map.get(m) > num) {
                num = map.get(m);
                max = m;
            }
        }
        return max;
    }
}
