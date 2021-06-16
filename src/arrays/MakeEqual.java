package arrays;
/*
https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
You are given an array of strings words (0-indexed).

In one operation, pick two distinct indices i and j, where words[i] is a non-empty string, and move any character from words[i]
to any position in words[j].

Return true if you can make every string in words equal using any number of operations, and false otherwise.
 */

public class MakeEqual {

    // Count the occurrence of every letter. If it's not divisible by the number of words then the answer is false.
    public boolean makeEqual(String[] words) {
        int[] letters = new int[26];
        int len = words.length;

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                letters[word.charAt(i) - 'a']++;
            }
        }

        for (int letter : letters) {
            if (letter % len != 0) {
                return false;
            }
        }

        return true;
    }
}
