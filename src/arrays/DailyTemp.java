package arrays;
/*
https://leetcode.com/problems/daily-temperatures/
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you
would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */

public class DailyTemp {
    public int[] dailyTemperatures(int[] T) {
        int[] arr = new int[T.length];

        for (int i = 0; i < T.length - 1; i++) {
            int days = 0;
            for (int j = i + 1; j < T.length; j++) {
                // Days increment until temperature is warmer than i-th index
                if (T[i] > T[j]) {
                    days++;
                } else {
                    break;
                }
            }
            // Populating new array with number of days until warmer temperature
            arr[i] = days;
        }
        return arr;
    }
}
