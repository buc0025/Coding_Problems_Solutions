package arrays;
/*
https://leetcode.com/problems/palindrome-number/
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Follow up: Could you solve it without converting the integer to a string?
 */

public class PalindromeNumber {
******Point of problem is to solve without converting integer to string*******
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int temp1 = x;
        int temp2 = x;
        int base = -1;

        // Finding the length of int by figuring out base multiplier
        while (temp1 > 0) {
            temp1 /= 10;
            base++;
        }

        int front = 0;
        int end = 0;

        while (x > 9) {
            // In order to find the front, x needs to be divided by it's base
            // e.g.(987 / 100 = 9)
            front = x / (int) Math.pow(10, base);
            x = x - front * (int) Math.pow(10, base);
            base--;
            // Use modulo to find end int and divide given num by 10 to go to next end number
            end = temp2 % 10;
            temp2 /= 10;

            if (front != end) {
                return false;
            }
        }

        return true;
    }
}
