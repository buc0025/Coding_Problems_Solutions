package arrays;
/*
https://leetcode.com/problems/mean-of-array-after-removing-some-elements/
Given an integer array arr, return the mean of the remaining integers after removing the smallest 5% and the largest 5% of the
elements.

Answers within 10-5 of the actual answer will be considered accepted.
 */

public class TrimMean {

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int fivePercent = arr.length / 20; // Number of elements to trim from front and back of array
        double sum = 0;
        double len = arr.length - fivePercent * 2; //New length of array after trimming front and back

        for (int i = fivePercent; i < arr.length - fivePercent; i++) {
            sum += arr[i];
        }

        return sum / len;
    }
}
