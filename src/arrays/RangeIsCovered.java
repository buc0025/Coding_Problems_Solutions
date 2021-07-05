package arrays;
/*
https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/
You are given a 2D integer array ranges and two integers left and right. Each ranges[i] = [starti, endi] represents an inclusive
interval between starti and endi.

Return true if each integer in the inclusive range [left, right] is covered by at least one interval in ranges. Return false
otherwise.

An integer x is covered by an interval ranges[i] = [starti, endi] if starti <= x <= endi.
 */

public class RangeIsCovered {

    /*
    Since the range of numbers only go up to 50, I used an array to keep track of all the elements that will be covered by the
    intervals in ranges by incrementing those elements. Then I only loop through the elements from left to right and uncover
    any elements that are visited in the intervals in ranges.
     */
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] arr = new int[50];

        for (int i = 0; i < ranges.length; i++) {
            for (int j = ranges[i][0] - 1; j < ranges[i][1]; j++) {
                arr[j]++;
            }
        }

        for (int i = left - 1; i < right; i++) {
            if (arr[i] == 0) {
                return false;
            }
        }

        return true;
    }
}
