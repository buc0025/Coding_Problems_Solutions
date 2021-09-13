package arrays;
/*
https://leetcode.com/problems/sqrtx/
Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 */

public class MySqrt {

    // Time limit is exceeded with current solution
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        for (int i = 0; i <= x; i++) {
            if (i * i > x) {
                return i - 1;
            }

            if (i * i == x) {
                return i;
            }
        }

        return x;
    }
}
