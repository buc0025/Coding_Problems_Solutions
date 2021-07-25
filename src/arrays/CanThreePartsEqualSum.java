package arrays;
/*
https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.

Formally, we can partition the array if we can find indexes i + 1 < j with (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] +
arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])
 */

public class CanThreePartsEqualSum {

    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;

        for (int a : arr) {
            sum += a;
        }

        if (sum % 3 != 0) {
            return false;
        }

        int count = 0;
        int part = 0;

        for (int a : arr) {
            part += a;

            if (part == sum / 3) {
                count++;
                part = 0;
            }

            if (count == 3) {
                return true;
            }
        }

        return false;
    }

    /*
    Create front array that holds the sum of the elements starting from the beginning of arr to arr.length - 2 because there needs
    to be 3 parts with equal sum. Create back array that does the same as front array but start adding the sum from the end of
    array til the beginning. If sum appears in both arrays and indexes don't over lap, we set the beginning and end pointer to
    find 2nd part with equal sum.
     */
    public boolean canThreePartsEqualSum(int[] arr) {
        int[] front = new int[arr.length - 2];
        int[] back = new int[arr.length - 2];

        int frontSum = 0;
        int backSum = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            frontSum += arr[i];
            front[i] = frontSum;
        }

        for (int i = arr.length - 1; i >= 2; i--) {
            backSum += arr[i];
            back[i-2] = backSum;
        }

        int equalSum;
        int midStart;
        int midEnd;

        for (int i = 0; i < front.length; i++) {
            equalSum = front[i];

            for (int j = i; j < back.length; j++) {
                if (equalSum == back[j]) {
                    midStart = i + 1;
                    midEnd = j + 1;

                    int midSum = 0;
                    for (int k = midStart; k <= midEnd; k++) {
                        midSum += arr[k];
                    }
                    if (midSum == equalSum) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
