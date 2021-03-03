package strings;
/*
https://leetcode.com/problems/repeated-substring-pattern/
Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of
the substring together.
 */

public class RepeatedSubstringPattern {

    // Substring will always start at index 0. We just need to find the indexes of the last char and get the substrings of
    // (0, indexes of last char) and append to make string.
    public boolean repeatedSubstringPattern(String s) {
        char lc = s.charAt(s.length()-1);

        for (int i = 0; i < s.length() / 2; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            // When we find last char within string
            if (s.charAt(i) == lc) {
                int times = s.length() / (i + 1); // The number of times substring will appear in string
                String part = s.substring(0, i + 1);

                while (times > 0) {
                    stringBuilder.append(part);
                    times--;
                }
            }
            if (s.equals(stringBuilder.toString())) {
                return true;
            }
        }
        return false;
    }
}
