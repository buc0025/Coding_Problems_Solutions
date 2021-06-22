package Maps_Sets_Tables;
/*
https://leetcode.com/problems/happy-number/
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.
 */

public class HappyNumber {

    /*
    The idea is to add all the integers that have been visited to a set. If the number has been visited before then it's in an
    infinite loop.
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            int clone = n;
            n = 0;
            while (clone > 0) {
                n += (clone % 10) * (clone % 10);
                clone /= 10;
            }
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
        }

        return true;
    }
}
