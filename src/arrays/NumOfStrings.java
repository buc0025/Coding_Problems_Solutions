package arrays;
/*
https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
Given an array of strings patterns and a string word, return the number of strings in patterns that exist as a substring in word.

A substring is a contiguous sequence of characters within a string.
 */

public class NumOfStrings {

    public int numOfStrings(String[] patterns, String word) {
        int result = 0;

        for (String pattern : patterns) {
            int len = pattern.length();

            if (len > word.length()) {
                continue;
            }

            for (int i = 0; i < word.length(); i++) {
                if (i + len > word.length()) {
                    break;
                }
                if (word.substring(i, i + len).equals(pattern)) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }
}
