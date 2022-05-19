package arrays;
/*
https://leetcode.com/problems/ugly-number/

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return true if n is an ugly number.
 */

public class IsUgly {

    // 5/18/2022 solution
    public boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        boolean factor = true;
        while (n > 1 && factor) {
            if (n % 2 == 0) {
                factor = true;
                n /= 2;
            } else if (n % 3 == 0) {
                factor = true;
                n /= 3;
            } else if (n % 5 == 0) {
                factor = true;
                n /= 5;
            } else {
                factor = false;
            }
        }

        return factor;
    }
}
