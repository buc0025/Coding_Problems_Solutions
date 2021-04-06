package arrays;
/*
https://leetcode.com/problems/relative-sort-array/
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in
arr2 should be placed at the end of arr1 in ascending order.
 */


public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>(); // keep track of occurrences in arr1

        int[] arr = new int[arr1.length]; // return new array

        for (int a : arr1) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int index = 0;

        for (int i = 0; i < arr2.length; i++) {
            //adding sorted elements of arr1 that appear in arr2 in relative order for new arr
            while (map.get(arr2[i]) > 0) {
                arr[index] = arr2[i];
                index++;
                map.put(arr2[i], map.get(arr2[i]) - 1);
            }
        }

        List<Integer> list = new ArrayList<>(); // contains elements in arr1 that were not in arr2

        for (int m : map.keySet()) {
            if (map.get(m) > 0) {
                while (map.get(m) > 0) {
                    list.add(m);
                    map.put(m, map.get(m) - 1);
                }
            }
        }

        Collections.sort(list);

        // adds rest of sorted elements in arr1 that were not in arr2 into new arr
        for (int l : list) {
            arr[index] = l;
            index++;
        }

        return arr;
    }

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
