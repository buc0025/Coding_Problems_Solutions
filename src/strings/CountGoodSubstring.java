package strings;
/*
https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
A string is good if there are no repeated characters.

Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

A substring is a contiguous sequence of characters in a string.
 */

public class CountGoodSubstring {

    public int countGoodSubstrings(String s) {
        int result = 0;

        for (int i = 0; i < s.length() - 2; i++) {

            String word = s.substring(i, i + 3);
            boolean noRepeat = true;

            if (word.charAt(0) == word.charAt(1) || word.charAt(1) == word.charAt(2) || word.charAt(0) == word.charAt(2)) {
                noRepeat = false;
            }

            if (noRepeat) {
                result++;
            }
        }

        return result;
    }
}
