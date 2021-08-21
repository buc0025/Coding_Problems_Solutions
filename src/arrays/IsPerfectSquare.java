package arrays;
/*
https://leetcode.com/problems/valid-perfect-square/
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.
 */

public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        if (num % 2 == 0) {
            for (int i = 2; i <= num / 2; i+=2) {
                if (i * i == num) {
                    return true;
                }
            }
        } else {
            for (int i = 1; i <= num / 2; i+=2) {
                if (i * i == num) {
                    return true;
                }
            }
        }

        return false;
    }
}
