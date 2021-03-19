package arrays;
/*
https://www.hackerrank.com/challenges/picking-numbers/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
Given an array of integers, find the longest subarray where the absolute difference between any two elements is less than or equal
to 1.
 */

public class PickingNumbers {

    public static int pickingNumbers(List<Integer> list) {
        Collections.sort(list);

        int start = list.get(0);
        int maxLen = 1;
        int restart = 1;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - start <= 1) {
                restart++;
                maxLen = Math.max(maxLen, restart);
            } else {
                start = list.get(i);
                maxLen = Math.max(maxLen, restart);
                restart = 1;
            }
        }

        return maxLen;
    }
}
