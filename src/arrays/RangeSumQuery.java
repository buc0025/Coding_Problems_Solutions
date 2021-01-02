package arrays;
/*
https://leetcode.com/problems/range-sum-query-mutable/
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
 */

public class RangeSumQuery {

    List<Integer> list;

    public NumArray(int[] nums) {
        list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
    }

    public void update(int i, int val) {
        list.remove(i);
        list.add(i, val);
    }

    public int sumRange(int i, int j) {
        int sum = 0;

        for (int first = i; first <= j; first++) {
            sum += list.get(first);
        }

        return sum;
    }
}
