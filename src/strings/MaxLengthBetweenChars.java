package strings;
/*
https://leetcode.com/problems/largest-substring-between-two-equal-characters/
Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there
is no such substring return -1.

A substring is a contiguous sequence of characters within a string.
 */

public class MaxLengthBetweenChars {

    /* Second solution is faster because it utilizes indexOf() and lastIndexOf() but uses extra space
    Top solution only uses one pass with no extra space besides an array to hold the indices of chars, the indices are compared
    when they reappear in the string */

    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;

        Set<Character> set = new HashSet<>();
        Set<Character> duplicates = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                duplicates.add(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }

        for (char c : duplicates) {
            max = Math.max(s.lastIndexOf(c) - s.indexOf(c) - 1, max);
        }

        return max;
    }

    // First solution but uses O(n)2 time
    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    max = Math.max(j - i - 1, max);
                }
            }
        }

        return max;
    }
}
