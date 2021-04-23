package arrays;
/*
https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions
(including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is
the modulo operation.
 */

public class CheckArraySortedRotated {
    /*
    Idea was to find the smallest element in the array and its index, from that index I will extract each element in order until
    all elements inside array has been extracted and placed into a list. The list is compared with a sorted array. If they match
    then it will return true. Unfortunately this only passed 102/105 test cases and didn't pass for arrays such as [6,10,6] where
    duplicates aren't side by side
     */
    public boolean check(int[] nums) {
        int len = nums.length;
        boolean check = true;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int start = arr[0];
        List<Integer> list = new ArrayList<>();

        int startIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == start) {
                startIndex = i;
                break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (startIndex >= len) {
                startIndex = 0;
            }
            list.add(nums[startIndex]);
            startIndex++;

            if (list.get(i) != arr[i]) {
                check = false;
            }
        }

        return check;
    }
}
