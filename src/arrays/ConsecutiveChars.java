package arrays;
/*
https://leetcode.com/problems/consecutive-characters/
Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.

Return the power of the string.
 */

public class ConsecutiveChars {

    public int maxPower(String s) {
        int max = 1;
        int count = 1;

        for (int i = 1; i <= s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 1;
            }
        }

        return max;
    }
}
