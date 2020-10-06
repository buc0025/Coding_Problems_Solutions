package arrays;
/*
https://leetcode.com/problems/minimum-operations-to-make-array-equal/
You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n).

In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x] and add 1 to arr[y]
(i.e. perform arr[x] -=1 and arr[y] += 1). The goal is to make all the elements of the array equal. It is guaranteed
that all the elements of the array can be made equal using some operations.

Given an integer n, the length of the array. Return the minimum number of operations needed to make all the elements of arr equal.
 */

public class MinOperations {
    //*******Solution passes test cases but exceeds time limit*******
    public int minOperations(int n) {
        int[] arr = new int[n];
        int count = 0;
        //populate array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (2 * i) + 1;
        }
        // left and right pointers in array
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // if neither elements equal to n then subtract 1 from right
            // element and add it to left element
            if (arr[left] != n && arr[right] != n) {
                arr[left] = arr[left] + 1;
                arr[right] = arr[right] - 1;
            }
            if (arr[left] == n) {
                left++;
            }
            if (arr[right] == n) {
                right--;
            }
            count++;
        }
        return count;
    }
    //*******Working solution but has nested while loops********
    public int minOperations(int n) {
        int[] arr = new int[n];
        int count = 0;
        //populate array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (2 * i) + 1;
        }
        // left and right pointers in array
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            while (arr[left] != arr[right]) {
                arr[left] += 1;
                arr[right] -= 1;
                count++;
            }
            left++;
            right--;
        }
        return count;
    }
}
