package arrays;
/*
https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.

Formally, we can partition the array if we can find indexes i + 1 < j with (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] +
arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])
 */

public class CanThreePartsEqualSum {

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

        for (int f : front) {
            System.out.print(f + " ");
        }
        System.out.println();
        for (int f : back) {
            System.out.print(f + " ");
        }


        int equalSum;
        int midStart;
        int midEnd;
        for (int i = 0; i < front.length; i++) {
            equalSum = front[i];

            for (int j = i; j < back.length; j++) {
                if (equalSum == back[j]) {
                    midStart = i + 1;
                    midEnd = j + i;

                    System.out.println("match is: " + equalSum);
                    System.out.println("midStart is: " + midStart);
                    System.out.println("midEnd is: " + midEnd);

                    int midSum = 0;
                    for (int k = midStart; k <= midEnd; k++) {
                        midSum += arr[k];
                    }
                    if (midSum == equalSum) {
                        System.out.println("it's a match");
                        break;
                    }
                }
            }
        }
    }
}
