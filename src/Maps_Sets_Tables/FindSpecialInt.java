package Maps_Sets_Tables;
/*
https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the
time, return that integer.
 */

public class FindSpecialInt {

    // More optimal solution without extra space and only 1 loop
    public int findSpecialInteger(int[] arr) {
        int max = arr.length / 4;
        int count = 1;
        int current = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] == current) {
                count++;
                if (count > max) {
                    break;
                }
            } else {
                current = arr[i + 1];
                count = 1;
            }
        }
        return current;
    }

    public int findSpecialInteger(int[] arr) {
        int max = arr.length / 4;
        int answer = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0 ) + 1);
        }

        for (int i : map.keySet()) {
            if (map.get(i) > max) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
