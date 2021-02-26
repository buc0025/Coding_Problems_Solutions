package strings;
/*
https://leetcode.com/problems/merge-strings-alternately/
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a
string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.
 */

public class MergeStrings {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder mergedString = new StringBuilder();
        int word1Len = 0;
        int word2Len = 0;

        while (word1Len < word1.length() && word2Len < word2.length()) {
            mergedString.append(word1.charAt(word1Len));
            mergedString.append(word2.charAt(word2Len));
            word1Len++;
            word2Len++;
        }

        while (word1Len < word1.length()) {
            mergedString.append(word1.charAt(word1Len));
            word1Len++;
        }

        while (word2Len < word2.length()) {
            mergedString.append(word2.charAt(word2Len));
            word2Len++;
        }

        return mergedString.toString();
    }
}
