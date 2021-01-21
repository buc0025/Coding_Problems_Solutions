package strings;
/*
https://leetcode.com/problems/longest-palindrome/
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built
with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        int ans = 0;
        boolean oddExists = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                ++lower[s.charAt(i) - 'a'];
            } else {
                ++upper[s.charAt(i) - 'A'];
            }
        }

        // Idea is to add all possible even number of chars to answer. If there's an odd amount for a char, take 1 away to make
        // it even.
        for (int l : lower) {
            if (l % 2 == 0) {
                ans += l;
            } else if (l % 2 == 1 && l > 2) {
                ans += (l - 1);
            }
            if (l % 2 == 1) {
                oddExists = true;
            }
        }

        for (int u : upper) {
            if (u % 2 == 0) {
                ans += u;
            } else if (u % 2 == 1 && u > 2) {
                ans += (u - 1);
            }
            if (u % 2 == 1) {
                oddExists = true;
            }
        }

        // If the string contains a char that occurs an odd number of times, the answer can contain one extra char
        if (oddExists) {
            return ans + 1;
        } else {
            return ans;
        }
    }

    // Incorrect attempt
    public int longestPalindrome(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        int ans = 0;
        int maxLow = 0;
        int maxUp = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                ++lower[s.charAt(i) - 'a'];
            } else {
                ++upper[s.charAt(i) - 'A'];
            }
        }

        for (int l : lower) {
            if (l % 2 == 0) {
                ans += l;
            } else {
                maxLow = Math.max(l, maxLow);
            }
        }

        for (int u : upper) {
            if (u % 2 == 0) {
                ans += u;
            } else {
                maxUp = Math.max(u, maxUp);
            }
        }

        return ans + Math.max(maxLow, maxUp);
    }
}
