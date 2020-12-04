package Maps_Sets_Tables;
/*
https://leetcode.com/problems/check-if-n-and-its-double-exist/
Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
More formally check if there exists two indices i and j such that :
i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
 */

public class CheckIfDoubleExists {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int a : arr) {
            if (set.contains(a * 2) || set.contains(a / 2) && a % 2 == 0) {
                return true;
            } else {
                set.add(a);
            }
        }

        return false;
    }

    // Originally had a tough time dealing with zero
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int zero = 0; //Kept an occurrence for zero because 2 * 0 is still 0

        for (int i = 0; i < arr.length; i++) {
            map.put(i, arr[i]);
            if (arr[i] == 0) {
                zero++;
            }
            if (zero > 1) {
                return true;
            }
        }

        for (int a : map.keySet()) {
            if (map.containsValue(map.get(a) * 2) && map.get(a) != 0) {
                return true;
            }
        }

        return false;
    }
}
