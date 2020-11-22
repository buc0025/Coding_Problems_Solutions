package Maps_Sets_Tables;
/*
https://leetcode.com/problems/unique-number-of-occurrences/
Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the
array is unique.
 */

public class UniqueOccurrences {

    // Previous problem that was not committed
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();

        for (int m : map.values()) {
            if (set.contains(m)) {
                return false;
            } else {
                set.add(m);
            }
        }

        return true;
    }
}
