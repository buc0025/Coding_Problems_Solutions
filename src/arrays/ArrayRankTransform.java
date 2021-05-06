package arrays;
/*
https://leetcode.com/problems/rank-transform-of-an-array/
Given an array of integers arr, replace each element with its rank.

The rank represents how large the element is. The rank has the following rules:

Rank is an integer starting from 1.
The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
Rank should be as small as possible.
 */

public class ArrayRankTransform {

    public int[] arrayRankTransform(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]));
            } else {
                map.put(arr[i], rank);
                rank++;
            }
        }

        int[] nums = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nums[i] = map.get(clone[i]);
        }

        return nums;
    }
}
