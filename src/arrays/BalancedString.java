package arrays;
/*
https://leetcode.com/problems/split-a-string-in-balanced-strings/
Balanced strings are those who have equal quantity of 'L' and 'R' characters.
Given a balanced string s split it in the maximum amount of balanced strings.
Return the maximum amount of splitted balanced strings.
 */

public class BalancedString {

    public int balancedStringSplit(String s) {
        int L = 0;
        int R = 0;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                L--;
            } else {
                R++;
            }
            if (L + R == 0) {
                sum++;
                L = 0;
                R = 0;
            }
        }
        return sum;
    }
}
