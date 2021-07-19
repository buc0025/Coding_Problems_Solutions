package strings;
/*
https://leetcode.com/problems/backspace-string-compare/
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace
character.

Note that after backspacing an empty text, the text will continue empty.
 */

public class BackspaceCompare {

    public boolean backspaceCompare(String s, String t) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        int sBackspace = 0;
        int tBackspace = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                sBackspace++;
            } else {
                if (sBackspace > 0) {
                    sBackspace--;
                    continue;
                }
                string1.append(s.charAt(i));
            }
        }

        for (int i = t.length() - 1; i >= 0; i--) {
            if (t.charAt(i) == '#') {
                tBackspace++;
            } else {
                if (tBackspace > 0) {
                    tBackspace--;
                    continue;
                }
                string2.append(t.charAt(i));
            }
        }

        return string1.toString().equals(string2.toString());
    }
}
