package arrays;
/*
https://leetcode.com/problems/calculate-money-in-leetcode-bank/
Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.

He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before.
On every subsequent Monday, he will put in $1 more than the previous Monday.
Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.
 */

public class TotalMoney {

    public int totalMoney(int n) {
        int sum = 0;
        int weeks = 0;
        int days = 0;

        if (n % 7 == 0) {
            weeks = n / 7;
        } else {
            weeks = n / 7;
            days = n % 7;
        }

        if (weeks > 0) {
            for (int i = 0; i < weeks; i++) {
                sum += 28 + i * 7;
            }
        }

        if (days > 0) {
            for (int i = weeks + 1; i <= weeks + days; i++) {
                sum += i;
            }
        }

        return sum;
    }
}
