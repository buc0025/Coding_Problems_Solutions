package strings;
/*
https://leetcode.com/problems/permutation-in-string/
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the
first string's permutations is the substring of the second string.
 */

public class PermutationInString {

    // Approach was to compare s1 to all substrings of s2 that's the length of s1
    public boolean checkInclusion(String s1, String s2) {
        int sLen = s1.length();

        for (int i = 0; i <= s2.length() - sLen; i++) {
            if (matchPerm(s1, s2.substring(i, i + sLen))) {
                return true;
            }
        }

        return false;
    }

    public boolean matchPerm(String s1, String s2) {
        int[] arr = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }

        for (int a : arr) {
            if (a > 0) {
                return false;
            }
        }

        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (s1MatchesS2(s1, s2.substring(i, i + s1.length()))) {
                return true;
            }
        }

        return false;
    }

    public boolean s1MatchesS2(String s1, String s2) {
        int[] arr = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            ++arr[s1.charAt(i) - 'a'];
            --arr[s2.charAt(i) - 'a'];
        }

        for (int a : arr) {
            if (a != 0) {
                return false;
            }
        }

        return true;
    }
}
