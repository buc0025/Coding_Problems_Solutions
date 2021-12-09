package arrays;
/*
https://edabit.com/challenge/Tzwb5uASZbKuESHhJ

Write a function that pairs the first number in an array with the last, the second number with the second to last, etc.
 */

public class BeginningEndPairs {

    public static int[][] pairs(int[] arr) {
        int len = arr.length / 2;
        boolean odd = false;

        if (arr.length % 2 != 0) {
            len++;
            odd = true;
        }

        int[][] result = new int[len][2];
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            result[left][0] = arr[left];
            result[left][1] = arr[right];
            left++;
            right--;
        }

        if (odd) {
            result[left][0] = arr[left];
            result[left][1] = arr[left];
        }

        return result;
    }
}
