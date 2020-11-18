package arrays;
/*
https://leetcode.com/problems/reverse-integer/
Given a 32-bit signed integer, reverse digits of an integer.
Note:
Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,
231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

public class ReverseInteger {

    public int reverse(int x) {
        int temp = x;
        boolean negative = x < 0;

        // Ignores negative numbers until the end
        if (x < 0) {
            x *= -1;
            temp *= -1;
        }

        int base = -1;
        long num = 0; // Storing number as long in case of overflow

        // Finds the largest place value of the given int
        while (x > 0) {
            x /= 10;
            base++;
        }

        while (temp > 0) {
            num += temp % 10 * (long) Math.pow(10, base);
            temp /= 10;
            base--;
            // Checks for overflow
            if (num > Integer.MAX_VALUE) {
                return 0;
            }
        }

        if (negative) {
            num *= -1;
        }

        return (int) num;
    }
}
