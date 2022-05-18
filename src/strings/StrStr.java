package strings;
/*
https://leetcode.com/problems/implement-strstr/

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part
of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's
indexOf().
 */

public class StrStr {

    // 5/17/2022 solution
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int len = needle.length();

        for (int i = 0; i <= haystack.length() - len; i++) {
            if (haystack.substring(i, i + len).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
