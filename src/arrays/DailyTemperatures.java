package arrays;
/*
https://leetcode.com/problems/daily-temperatures/
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the
number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is
possible, keep answer[i] == 0 instead.
 */

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int count = 0;
            int end = temperatures.length - i - 1; // Counts number of elements until it reaches end of array
            for (int j = i + 1; j < temperatures.length; j++) {
                count++;
                // Break out early when we find a higher temperature
                if (temperatures[j] > temperatures[i]) {
                    break;
                }
                // Since every at temperature[j] was <= temperature[i], the count becomes 0
                if (j == temperatures.length - 1 && count == end) {
                    count = 0;
                }
            }
            result[i] = count;
        }

        return result;
    }
}
