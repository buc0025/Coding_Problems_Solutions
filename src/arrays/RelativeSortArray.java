package arrays;
/*
https://leetcode.com/problems/relative-sort-array/
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in
arr2 should be placed at the end of arr1 in ascending order.
 */


public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr1) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        int[] arr = new int[arr1.length];
        int index = 0;

        for (int a : arr2) {
            while (map.get(a) > 0) {
                arr[index] = a;
                index++;
                map.put(a, map.get(a) - 1);
            }
        }

        int[] leftover = new int[arr1.length - index];
        int lindex = 0;

        for (int m : map.keySet()) {
            while (map.get(m) > 0) {
                leftover[lindex] = m;
                lindex++;
                map.put(m, map.get(m) - 1);
            }
        }

        Arrays.sort(leftover);

        for (int l : leftover) {
            arr[index] = l;
            index++;
        }

        return arr;
    }
}
