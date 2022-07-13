package arrays;
/*
https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
You are given a positive integer num consisting of exactly four digits. Split num into two new integers new1 and new2 by using the
digits found in num. Leading zeros are allowed in new1 and new2, and all the digits found in num must be used.

For example, given num = 2932, you have the following digits: two 2's, one 9 and one 3. Some of the possible pairs [new1, new2]
are [22, 93], [23, 92], [223, 9] and [2, 329].
Return the minimum possible sum of new1 and new2.
 */

public class MinimumSum {

    // 7/12/2022 solution
    public int minimumSum(int num) {
        int[] arr = new int[4];
        int index = 0;

        while (num > 0) {
            arr[index] = num % 10;
            num /= 10;
            index++;
        }

        Arrays.sort(arr);

        int new1 = arr[0] * 10 + arr[2];
        int new2 = arr[1] * 10 + arr[3];

        return new1 + new2;
    }

    // 3/28/2022 solution
    public int minimumSum(int num) {
        String number = String.valueOf(num);
        int[] arr = new int[10];

        for (int i = 0; i < number.length(); i++) {
            int n = Integer.valueOf(number.substring(i, i + 1));
            arr[n]++;
        }

        String start = "";
        String end = "";
        int beginning = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int repeat = arr[i];
                while (beginning < 2 && repeat > 0) {
                    start += String.valueOf(i);
                    beginning++;
                    arr[i]--;
                    repeat--;
                }
            }
            if (beginning == 2) {
                break;
            }
        }

        beginning = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                int repeat = arr[i];
                while (beginning < 2 && repeat > 0) {
                    end += String.valueOf(i);
                    beginning++;
                    arr[i]--;
                    repeat--;
                }
            }
            if (beginning == 2) {
                break;
            }
        }

        String first = start.substring(0, 1) + end.substring(0, 1);
        String second = start.substring(1) + end.substring(1);

        return Integer.valueOf(first) + Integer.valueOf(second);
    }
}
