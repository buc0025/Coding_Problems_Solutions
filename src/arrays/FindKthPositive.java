package arrays;
/*
https://leetcode.com/problems/kth-missing-positive-number/
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Find the kth positive integer that is missing from this array.
 */

public class FindKthPositive {

    /*
    The missing number is either going to be greater than or less than the last element in the array. I used another array to
    keep track of the missing elements from arr. Each time there is a missing element from arr, I would increment the placeholder
    until it's the same as k. If I have looped through the entire nums array, that means the missing number is greater than the
    last element in arr. Then I would just add the difference of k and placeholder to the last element in arr.
     */
    public int findKthPositive(int[] arr, int k) {
        int max = arr[arr.length - 1];

        int[] nums = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            nums[arr[i]]++;
        }

        int placeholder = 0;
        int missing = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                placeholder++;
            }
            if (placeholder == k) {
                missing = i;
                break;
            }
        }

        return missing == 0 ? max + (k - placeholder) : missing;
    }
}
