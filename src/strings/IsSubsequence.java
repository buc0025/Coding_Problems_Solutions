package strings;
/*
https://leetcode.com/problems/is-subsequence/
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters
without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */

public class IsSubsequence {

    /*
    We only have to care about the order in string s. Once we find the first element in string t that matches with first char in
    string s, we keep track of where the index was last left off in string t. We keep a count every time the elements match up and
     compare it to the length of string s.
     */

    // 6/23/2022 solution
    public boolean isSubsequence(String s, String t) {
        int tIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean subsequence = false;
            for (int j = tIndex; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    tIndex = ++j;
                    subsequence = true;
                    break;
                }
            }
            if (!subsequence) {
                return false;
            }
        }

        return true;
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        if (s.length() > t.length()) {
            return false;
        }

        int index = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            while (index < t.length()) {
                if (s.charAt(i) == t.charAt(index)) {
                    index++;
                    count++;
                    break;
                } else {
                    index++;
                }
            }
        }

        return count == s.length();
    }
}
