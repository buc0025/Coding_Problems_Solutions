package arrays;
/*
https://leetcode.com/problems/power-of-three/

Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.
 */

public class IsPowerOfThree {

    // 5/23/2022 solution
    public boolean isPowerOfThree(int n) {
        if (n < 0) {
            return false;
        }

        while (n > 1 && n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
