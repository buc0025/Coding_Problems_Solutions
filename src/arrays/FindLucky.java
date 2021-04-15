package arrays;
/*
https://leetcode.com/problems/find-lucky-integer-in-an-array/
Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.

Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer
return -1.
 */

public class FindLucky {

    public int findLucky(int[] arr) {
        int[] container = new int[500];

        for (int i = 0; i < arr.length; i++) {
            container[arr[i]-1]++;
        }

        int max = -1;

        for (int i = 0; i < arr.length; i++) {
            if (container[arr[i] - 1] == arr[i]) {
                max = Math.max(arr[i], max);
            }
        }

        return max;
    }
}
