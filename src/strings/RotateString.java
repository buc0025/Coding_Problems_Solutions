package strings;
/*
https://leetcode.com/problems/rotate-string/
We are given two strings, s and goal.

A shift on s consists of taking string s and moving the leftmost character to the rightmost position. For example, if s = 'abcde',
then it will be 'bcdea' after one shift on s. Return true if and only if s can become goal after some number of shifts on s.
 */

public class RotateString {

    // 7/25/2022 solution
    public boolean rotateString(String s, String goal) {
        if (s.equals(goal)) {
            return true;
        }

        for (int i = 1; i < s.length(); i++) {
            String shift = s.substring(i) + s.substring(0, i);
            if (shift.equals(goal)) {
                return true;
            }
        }

        return false;
    }

    /* o(n) runtime instead of o(n2) by checking if s.charAt(i) is equal to first char of goal. If it is then I rotate s to see if
    it matches goal.
    */
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == goal.charAt(0)) {
                if ((s.substring(i) + s.substring(0, i)).equals(goal)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            return true;
        }

        int index = 0;

        for (int i = 0; i < s.length()-1; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            index++;

            for (int j = index; j < s.length(); j++) {
                stringBuilder.append(s.charAt(j));
            }

            for (int n = 0; n < index; n++) {
                stringBuilder.append(s.charAt(n));
            }

            if (stringBuilder.toString().equals(goal)) {
                return true;
            }
        }

        return false;
    }
}
